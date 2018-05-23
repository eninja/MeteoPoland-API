package pl.eninja.meteo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.eninja.meteo.domain.measurementsdto.AirMeasurementsDto;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;
import pl.eninja.meteo.domain.measurementsdto.SynopticMeasurementDto;
import pl.eninja.meteo.supplier.MeasuringStationApiSupplier;
import pl.eninja.meteo.supplier.SynopticStationApiSupplier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
class ApiSupplierRetriever {

    public Map<Integer, AirMeasurementsDto> airMeasurementsProcessor() {
        RestTemplate restTemplate = new RestTemplate();
        String url = MeasuringStationApiSupplier.measurementsAdi;
        Map<Integer, AirMeasurementsDto> airMap = new HashMap<>();
        for (MeasuringStationDto measuringStationDto : measuringStationApiProcessor()) {
            int stationId = measuringStationDto.getId();
            AirMeasurementsDto obj = restTemplate.getForObject(url + stationId, AirMeasurementsDto.class);
            airMap.put(stationId, obj);
        }
        return airMap;
    }

    public List<MeasuringStationDto> measuringStationApiProcessor() {
        RestTemplate restTemplate = new RestTemplate();
        String url = MeasuringStationApiSupplier.allMeasuringStationsApi;
        ResponseEntity<MeasuringStationDto[]> responseEntity = restTemplate.getForEntity(url,
                                                                                         MeasuringStationDto[].class);
        synopticMeasurementProcessor();
        return Arrays.stream(responseEntity.getBody()).collect(Collectors.toList());
    }

    public Map<String, SynopticMeasurementDto> synopticMeasurementProcessor() {
        RestTemplate restTemplate = new RestTemplate();
        String url = SynopticStationApiSupplier.allSynopticStationsData;
        ResponseEntity<SynopticMeasurementDto[]> responseEntity = restTemplate.getForEntity(url,
                                                                                            SynopticMeasurementDto[].class);
        return Arrays.stream(responseEntity.getBody())
                     .collect(Collectors.toMap(SynopticMeasurementDto::getCity, v -> v));
    }
}
