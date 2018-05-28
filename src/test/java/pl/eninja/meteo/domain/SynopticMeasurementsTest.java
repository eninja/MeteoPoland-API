package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockSynopticMeasurementsRepository;

public class SynopticMeasurementsTest {

    private final MockSynopticMeasurementsRepository synopticRepository = new MockSynopticMeasurementsRepository();

    @Test
    public void equalsTest() {

        new EqualsTester().addEqualityGroup(synopticRepository.equalsList().get(0),
                                            synopticRepository.equalsList().get(1)).testEquals();
    }
}