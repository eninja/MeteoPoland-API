package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class MeasuringStationOnLineTest {
    @Test
    public void equalsTest() {
        MeasuringStationOnLine station1 = new MeasuringStationOnLine.Builder().stationCity("city")
                                                                              .stationDistrict("district")
                                                                              .stationName("name")
                                                                              .stationStreet("station")
                                                                              .gegrLatitude(12.12)
                                                                              .gegrLongitude(12.12)
                                                                              .build();
        MeasuringStationOnLine station2 = new MeasuringStationOnLine.Builder().stationCity("city")
                                                                              .stationDistrict("district")
                                                                              .stationName("name")
                                                                              .stationStreet("station")
                                                                              .gegrLatitude(12.12)
                                                                              .gegrLongitude(12.12)
                                                                              .build();
        new EqualsTester().addEqualityGroup(station1, station2).testEquals();
    }
}