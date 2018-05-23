package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class CityRegionDtoTest {

    @Test
    public void equalsTest() {
        CityRegionDto cityRegionDto1 = new CityRegionDto();
        cityRegionDto1.setCommuneName("commune");
        cityRegionDto1.setDistrictName("district");
        cityRegionDto1.setVoivodeship("voivodeship");
        CityRegionDto cityRegionDto2 = new CityRegionDto();
        cityRegionDto2.setCommuneName("commune");
        cityRegionDto2.setDistrictName("district");
        cityRegionDto2.setVoivodeship("voivodeship");

        new EqualsTester().addEqualityGroup(cityRegionDto1, cityRegionDto2).testEquals();
    }
}