package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.measurementsdto.CityRegionDto;

import java.util.ArrayList;
import java.util.List;

public class MockCityRegionDtoRepository {

    public List<CityRegionDto> equalsList() {
        CityRegionDto cityRegionDto1 = new CityRegionDto();
        cityRegionDto1.setCommuneName("commune");
        cityRegionDto1.setDistrictName("district");
        cityRegionDto1.setVoivodeship("voivodeship");
        CityRegionDto cityRegionDto2 = new CityRegionDto();
        cityRegionDto2.setCommuneName("commune");
        cityRegionDto2.setDistrictName("district");
        cityRegionDto2.setVoivodeship("voivodeship");
        List<CityRegionDto> cityRegionDtoList = new ArrayList<>();
        cityRegionDtoList.add(cityRegionDto1);
        cityRegionDtoList.add(cityRegionDto2);
        return cityRegionDtoList;
    }
}