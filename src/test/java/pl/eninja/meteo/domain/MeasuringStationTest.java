package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class MeasuringStationTest {
    @Test
    public void equalsTest() {
        MeasuringStation station1 = new MeasuringStation();
        station1.setCity("city");
        station1.setLatitude("latitude");
        station1.setLongitude("longitude");
        station1.setStationId(1);
        station1.setStationName("station");
        MeasuringStation station2 = new MeasuringStation();
        station2.setCity("city");
        station2.setLatitude("latitude");
        station2.setLongitude("longitude");
        station2.setStationId(1);
        station2.setStationName("station");
        new EqualsTester().addEqualityGroup(station1, station2).testEquals();
    }
}