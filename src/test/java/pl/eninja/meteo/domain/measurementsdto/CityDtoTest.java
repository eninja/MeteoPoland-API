package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class CityDtoTest {

    @Test
    public void equalsTest() {
        CityDto cityDto1 = new CityDto();
        cityDto1.setCityName("city");
        cityDto1.setId(1);
        CityDto cityDto2 = new CityDto();
        cityDto2.setCityName("city");
        cityDto2.setId(1);
        new EqualsTester().addEqualityGroup(cityDto1, cityDto2).testEquals();
    }
}