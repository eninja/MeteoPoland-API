package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockAirRepository;

public class AirMeasurementsTest {
    private MockAirRepository mockAirRepository = new MockAirRepository();

    @Test
    public void equalsTest() {
        new EqualsTester().addEqualityGroup(mockAirRepository.airMeasurements1().get(0),
                                            mockAirRepository.airMeasurements1().get(2)).testEquals();
    }
}