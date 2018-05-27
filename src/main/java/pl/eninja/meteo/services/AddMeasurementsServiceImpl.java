package pl.eninja.meteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.domain.SynopticMeasurements;
import pl.eninja.meteo.domain.measurementsdto.AirMeasurementsDto;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;
import pl.eninja.meteo.domain.measurementsdto.SynopticMeasurementDto;
import pl.eninja.meteo.mapper.AirMeasurementMapper;
import pl.eninja.meteo.mapper.SynopticMeasurementMapper;
import pl.eninja.meteo.repositories.AirMeasurementRepository;
import pl.eninja.meteo.repositories.MeasuringStationRepository;
import pl.eninja.meteo.repositories.SynopticMeasurementRepository;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
public class AddMeasurementsServiceImpl implements AddMeasurementsService {

    private final ApiSupplierRetriever apiSupplierRetriever;
    private final MeasuringStationRepository measuringStationRepository;
    private final AirMeasurementMapper airMapper;
    private final SynopticMeasurementMapper synopticMapper;
    private final SynopticMeasurementRepository synopticRepository;
    private final AirMeasurementRepository airRepository;
    private final MeasuringOnlineServices measuringOnlineServices;

    @Autowired
    public AddMeasurementsServiceImpl(ApiSupplierRetriever apiSupplierRetriever, MeasuringStationRepository measuringStationRepository, AirMeasurementMapper airMapper, SynopticMeasurementMapper synopticMapper, SynopticMeasurementRepository synopticRepository, AirMeasurementRepository airRepository, MeasuringOnlineServices measuringOnlineServices) {
        this.apiSupplierRetriever = apiSupplierRetriever;
        this.measuringStationRepository = measuringStationRepository;
        this.airMapper = airMapper;
        this.synopticMapper = synopticMapper;
        this.synopticRepository = synopticRepository;
        this.airRepository = airRepository;
        this.measuringOnlineServices = measuringOnlineServices;
    }

    @Transactional
    @Override
    public String addMeasurements(int stationId) {
        int id = 0;
        long startTime1 = System.currentTimeMillis();
        for (MeasuringStationDto measuringStationDto : apiSupplierRetriever.measuringStationApiProcessor()) {
            if (measuringStationDto.getId() == stationId) {
                id = measuringStationDto.getId();
            }
        }

        if (id > 0) {
            AirMeasurementsDto airDto = apiSupplierRetriever.airMeasurementsProcessor().get(stationId);
            measuringOnlineServices.addAllStations();
            SynopticMeasurementDto synoptic = new SynopticMeasurementDto();
            MeasuringStationDto msDto = new MeasuringStationDto();

            for (MeasuringStationDto measuringStationDto : apiSupplierRetriever.measuringStationApiProcessor()) {
                if (measuringStationDto.getId() == stationId) {
                    msDto = measuringStationDto;
                    synoptic = Optional.ofNullable(apiSupplierRetriever.synopticMeasurementProcessor()
                                                                       .get(msDto.getCityDto().getCityName()))
                                       .orElse(emptyObj());
                }
            }

            MeasuringStation measuringStation = measuringStationRepository.findByStationId(stationId);

            AirMeasurements airMeasurements = airMapper.mapToAirMeasurements(airDto);
            airRepository.save(airMeasurements);
            measuringStation.getAirMeasurementsList().add(airMeasurements);

            SynopticMeasurements synopticMeasurements = synopticMapper.maptToSynopticMeasurement(synoptic);
            synopticRepository.save(synopticMeasurements);
            measuringStation.getSynopticMeasurements().add(synopticMeasurements);
            airMeasurements.setMeasuringStation(measuringStation);
            synopticMeasurements.setMeasuringStation(measuringStation);
            measuringStationRepository.save(measuringStation);
            long endTime1 = System.currentTimeMillis();
            DecimalFormat df2 = new DecimalFormat("###.###");
            double execution = (endTime1 - startTime1) / 60000.0;
            return "Measurement execution time: " + df2.format(execution) + " minutes, saved as below: \n" + measuringStation + "\n" + "######################################################################################### \n" + synopticMeasurements + "\n" + "######################################################################################### \n" + airMeasurements;
        }
        return " No data for measuring station Id: " + stationId;
    }

    //@Transactional
    @Override
    public String addMeasurementsAllStations() {
        measuringOnlineServices.addAllStations();
        List<MeasuringStationDto> mSDtoList = apiSupplierRetriever.measuringStationApiProcessor();
        long startTime1 = System.currentTimeMillis();
        for (MeasuringStationDto msDto : mSDtoList) {
            int id = msDto.getId();
            AirMeasurementsDto airMeasurementsDto = apiSupplierRetriever.airMeasurementsProcessor().get(id);
            String cityName = Optional.ofNullable(msDto.getCityDto().getCityName()).orElse("no data");
            SynopticMeasurementDto synoptic = Optional.ofNullable(apiSupplierRetriever.synopticMeasurementProcessor()
                                                                                      .get(cityName))
                                                      .orElse(emptyObj());
            MeasuringStation measuringStation = measuringStationRepository.findByStationId(id);

            AirMeasurements airMeasurements = airMapper.mapToAirMeasurements(airMeasurementsDto);
            airRepository.save(airMeasurements);
            measuringStation.getAirMeasurementsList().add(airMeasurements);

            SynopticMeasurements synopticMeasurements = synopticMapper.maptToSynopticMeasurement(synoptic);
            synopticRepository.save(synopticMeasurements);
            measuringStation.getSynopticMeasurements().add(synopticMeasurements);

            airMeasurements.setMeasuringStation(measuringStation);
            synopticMeasurements.setMeasuringStation(measuringStation);
            measuringStationRepository.save(measuringStation);
        }
        long endTime1 = System.currentTimeMillis();
        DecimalFormat df2 = new DecimalFormat("###.###");
        double execution = (endTime1 - startTime1) / 60000.0;
        return "Measured time of downloading data: " + df2.format(execution) + " minutes\n" + mSDtoList.size() + " measurements added to data base correct";
    }

    private SynopticMeasurementDto emptyObj() {
        return new SynopticMeasurementDto(9999, "->>no data available<<-", 9999.0, 9999.0, 9999.0, 9999.0);
    }
}
