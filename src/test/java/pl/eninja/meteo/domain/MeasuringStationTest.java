package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockMeasuringStation;

public class MeasuringStationTest {
    private final MockMeasuringStation mockMeasuringStation = new MockMeasuringStation();

    @Test
    public void equalsTest() {
        new EqualsTester().addEqualityGroup(mockMeasuringStation.equalsList().get(0),
                                            mockMeasuringStation.equalsList().get(1)).testEquals();
    }
}