package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockMeasuringStationOnLine;

public class MeasuringStationOnLineTest {
    private MockMeasuringStationOnLine mock = new MockMeasuringStationOnLine();

    @Test
    public void equalsTest() {
        new EqualsTester().addEqualityGroup(mock.equalList().get(0), mock.equalList().get(1)).testEquals();
    }
}