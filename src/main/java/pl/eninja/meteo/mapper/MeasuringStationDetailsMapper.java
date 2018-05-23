package pl.eninja.meteo.mapper;

import org.springframework.stereotype.Component;
import pl.eninja.meteo.domain.MeasuringStationDetails;
import pl.eninja.meteo.domain.measurementsdto.CityRegionDto;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;

@Component
public class MeasuringStationDetailsMapper {

    public MeasuringStationDetails mapToStationDetails(MeasuringStationDto stationDto) {
        CityRegionDto cityRegionDto = stationDto.getCityDto().getCityRegionDto();
        return new MeasuringStationDetails.Builder().city(stationDto.getCityDto().getCityName())
                                                    .commune(cityRegionDto.getCommuneName())
                                                    .district(cityRegionDto.getDistrictName())
                                                    .voivodeship(cityRegionDto.getVoivodeship())
                                                    .build();
    }
}
