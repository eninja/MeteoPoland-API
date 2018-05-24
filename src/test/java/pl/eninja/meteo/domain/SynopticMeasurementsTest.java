package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class SynopticMeasurementsTest {
    @Test
    public void equalsTest() {
        SynopticMeasurements measurements1 = new SynopticMeasurements.Builder().city("city")
                                                                               .foreignId(1)
                                                                               .id(1L)
                                                                               .airHumidity(12.12)
                                                                               .pressure(13.13)
                                                                               .temperature(28.28)
                                                                               .windSpeed(25.25)
                                                                               .build();
        SynopticMeasurements measurements2 = new SynopticMeasurements.Builder().city("city")
                                                                               .foreignId(1)
                                                                               .id(1L)
                                                                               .airHumidity(12.12)
                                                                               .pressure(13.13)
                                                                               .temperature(28.28)
                                                                               .windSpeed(25.25)
                                                                               .build();
        new EqualsTester().addEqualityGroup(measurements1, measurements2).testEquals();
    }
}