package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class MeasuringStationDtoTest extends DtoTest<MeasuringStationDto> {

    @Test
    public void equalsTest() {
        MeasuringStationDto stationDto1 = new MeasuringStationDto();
        stationDto1.setId(1);
        stationDto1.setAddressStreet("street");
        stationDto1.setCityDto(new CityDto());
        stationDto1.setGegrLat("lat");
        stationDto1.setGegrLon("lon");
        stationDto1.setStationName("station");
        MeasuringStationDto stationDto2 = new MeasuringStationDto();
        stationDto2.setId(1);
        stationDto2.setAddressStreet("street");
        stationDto2.setCityDto(new CityDto());
        stationDto2.setGegrLat("lat");
        stationDto2.setGegrLon("lon");
        stationDto2.setStationName("station");
        new EqualsTester().addEqualityGroup(stationDto1, stationDto2).testEquals();
    }

    @Override
    protected MeasuringStationDto getInstance() {
        return new MeasuringStationDto();
    }
}