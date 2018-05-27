package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.measurementsdto.CityDto;

import java.util.ArrayList;
import java.util.List;

public class MockCityDtoRepository {
    private final MockCityRegionDtoRepository cityRegionDtoRepository = new MockCityRegionDtoRepository();

    public List<CityDto> equalsList() {
        CityDto cityDto1 = new CityDto();
        cityDto1.setCityName("Warszawa");
        cityDto1.setCityRegionDto(cityRegionDtoRepository.equalsList().get(0));
        cityDto1.setId(1);
        CityDto cityDto2 = new CityDto();
        cityDto2.setCityName("Warszawa");
        cityDto2.setId(1);
        cityDto2.setCityRegionDto(cityRegionDtoRepository.equalsList().get(0));
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(cityDto1);
        cityDtoList.add(cityDto2);
        return cityDtoList;
    }
}