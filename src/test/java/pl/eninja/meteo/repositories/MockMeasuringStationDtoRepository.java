package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.measurementsdto.CityDto;
import pl.eninja.meteo.domain.measurementsdto.CityRegionDto;
import pl.eninja.meteo.domain.measurementsdto.MeasuringStationDto;

import java.util.ArrayList;
import java.util.List;

public class MockMeasuringStationDtoRepository {

    private final MockCityDtoRepository mockCityDtoRepository = new MockCityDtoRepository();

    public List<MeasuringStationDto> equalsList() {
        MeasuringStationDto station1 = new MeasuringStationDto();
        station1.setId(1);
        station1.setStationName("Warszawa");
        station1.setGegrLat("15");
        station1.setGegrLon("15");
        station1.setAddressStreet("street");
        station1.setCityDto(mockCityDtoRepository.equalsList().get(0));
        MeasuringStationDto station2 = new MeasuringStationDto();
        station2.setId(1);
        station2.setStationName("Warszawa");
        station2.setGegrLat("15");
        station2.setGegrLon("15");
        station2.setAddressStreet("street");
        station2.setCityDto(mockCityDtoRepository.equalsList().get(0));
        List<MeasuringStationDto> dtoList = new ArrayList<>();
        dtoList.add(station1);
        dtoList.add(station2);
        return dtoList;
    }

    public MeasuringStationDto mapperStationDto() {
        MeasuringStationDto stationDto = new MeasuringStationDto();
        stationDto.setId(1);
        stationDto.setStationName("station");
        stationDto.setGegrLat("15");
        stationDto.setGegrLon("15");
        stationDto.setAddressStreet("street");
        stationDto.setCityDto(new CityDto());
        return stationDto;
    }

    public MeasuringStationDto mapperOnlineStationDto() {
        CityRegionDto cityRegionDto = new CityRegionDto();
        cityRegionDto.setVoivodeship("voivodeship");
        cityRegionDto.setDistrictName("district");
        cityRegionDto.setCommuneName("commune");

        CityDto cityDto = new CityDto();
        cityDto.setId(1);
        cityDto.setCityName("city");
        cityDto.setCityRegionDto(cityRegionDto);

        MeasuringStationDto stationDto = new MeasuringStationDto();
        stationDto.setId(1);
        stationDto.setStationName("station");
        stationDto.setGegrLat("15");
        stationDto.setGegrLon("15");
        stationDto.setAddressStreet("street");
        stationDto.setCityDto(cityDto);
        return stationDto;
    }
}