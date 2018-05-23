package pl.eninja.meteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.domain.MeasuringStationDetails;
import pl.eninja.meteo.domain.MeasuringStationOnLine;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;
import pl.eninja.meteo.mapper.MeasuringStationDetailsMapper;
import pl.eninja.meteo.mapper.MeasuringStationMapper;
import pl.eninja.meteo.repositories.MeasuringStationRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasuringOnlineServicesImpl implements MeasuringOnlineServices {

    private final MeasurementStationProcessor msProc;
    private final MeasuringStationRepository stRepository;
    private final MeasuringStationMapper stMapper;
    private final MeasuringStationDetailsMapper staDetMapper;
    private final ApiSupplierRetriever apiSupplierRetriver;

    @Autowired
    public MeasuringOnlineServicesImpl(MeasurementStationProcessor msProc, MeasuringStationRepository stRepository, MeasuringStationMapper stMapper, MeasuringStationDetailsMapper staDetMapper, ApiSupplierRetriever apiSupplierRetriver) {
        this.msProc = msProc;
        this.stRepository = stRepository;
        this.stMapper = stMapper;
        this.staDetMapper = staDetMapper;
        this.apiSupplierRetriver = apiSupplierRetriver;
    }

    @Override
    public List<MeasuringStationOnLine> getAllMeasuringStations() {
        return msProc.fillMeasuringStationListStructure();
    }

    @Override
    public List<MeasuringStationOnLine> getGivenCityMeasuringStationsWithSynopticData(String stationCity) {
        return msProc.fillMeasuringStationListStructure()
                     .stream()
                     .filter(c -> c.getStationCity().toLowerCase().contains(stationCity.toLowerCase()))
                     .collect(Collectors.toList());
    }

    @Override
    public MeasuringStationOnLine getHottestOnlineStation() {
        return msProc.fillMeasuringStationListStructure()
                     .stream()
                     .filter(f -> f.getSynoptics().getTemperature() < 9999)
                     .max(Comparator.comparing(t -> t.getSynoptics().getTemperature()))
                     .orElse(null);
    }

    @Override
    public MeasuringStationOnLine getColdestOnlineStation() {
        return msProc.fillMeasuringStationListStructure()
                     .stream()
                     .filter(f -> f.getSynoptics().getTemperature() < 9999)
                     .min(Comparator.comparing(t -> t.getSynoptics().getTemperature()))
                     .orElse(null);
    }

    public void addAllStations() {
        for (MeasuringStationDto measuringStationDto : apiSupplierRetriver.measuringStationApiProcessor()) {
            int id = measuringStationDto.getId();
            if (!stRepository.existsAllByStationId(id)) {
                MeasuringStation measuringStation = stMapper.mapToMeasuringSt(measuringStationDto);
                MeasuringStationDetails stDetails = staDetMapper.mapToStationDetails(measuringStationDto);
                measuringStation.setStationDetails(stDetails);
                stRepository.save(measuringStation);
            }
        }
    }
}
