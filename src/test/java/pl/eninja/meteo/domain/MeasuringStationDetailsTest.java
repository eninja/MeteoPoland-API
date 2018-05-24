package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockMeasuringStationDetailsRepository;

public class MeasuringStationDetailsTest {

    private MockMeasuringStationDetailsRepository repository = new MockMeasuringStationDetailsRepository();

    @Test
    public void equalsTest() {

        new EqualsTester().addEqualityGroup(repository.equalsList().get(0), repository.equalsList().get(1))
                          .testEquals();
    }
}