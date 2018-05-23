package pl.eninja.meteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.eninja.meteo.domain.MeasuringStationOnLine;
import pl.eninja.meteo.domain.measurementsdto.AirMeasurementsDto;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;
import pl.eninja.meteo.domain.measurementsdto.SynopticMeasurementDto;
import pl.eninja.meteo.mapper.MeasuringStationOnLineMapper;

import java.util.List;
import java.util.Map;

@Service
public class MeasurementStationProcessor {

    private final ApiSupplierRetriever apiSupplierRetriever;
    private final MeasuringStationOnLineMapper measuringStationMapper;

    @Autowired
    public MeasurementStationProcessor(ApiSupplierRetriever apiSupplierRetriever, MeasuringStationOnLineMapper measuringStationMapper) {
        this.apiSupplierRetriever = apiSupplierRetriever;
        this.measuringStationMapper = measuringStationMapper;
    }

    public List<MeasuringStationOnLine> fillMeasuringStationListStructure() {
        List<MeasuringStationDto> msDto = apiSupplierRetriever.measuringStationApiProcessor();
        Map<String, SynopticMeasurementDto> synoptic = apiSupplierRetriever.synopticMeasurementProcessor();
        Map<Integer, AirMeasurementsDto> air = apiSupplierRetriever.airMeasurementsProcessor();
        return measuringStationMapper.mapToMeasuringStationList(msDto, air, synoptic);
    }
}
