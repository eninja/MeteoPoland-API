package pl.eninja.meteo.mapper;

import org.springframework.stereotype.Component;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;

@Component
public class MeasuringStationMapper {

    public MeasuringStation mapToMeasuringSt(MeasuringStationDto stationDto) {
        MeasuringStation measuringStation = new MeasuringStation();
        measuringStation.setStationId(stationDto.getId());
        measuringStation.setStationName(stationDto.getStationName());
        measuringStation.setLatitude(stationDto.getGegrLat());
        measuringStation.setLongitude(stationDto.getGegrLon());
        measuringStation.setStreet(stationDto.getAddressStreet());
        measuringStation.setCity(stationDto.getCityDto().getCityName());
        return measuringStation;
    }
}
