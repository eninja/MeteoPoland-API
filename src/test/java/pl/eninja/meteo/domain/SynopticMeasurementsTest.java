package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockSynopticRepository;

public class SynopticMeasurementsTest {

    private MockSynopticRepository synopticRepository = new MockSynopticRepository();

    @Test
    public void equalsTest() {

        new EqualsTester().addEqualityGroup(synopticRepository.equalsList().get(0),
                                            synopticRepository.equalsList().get(1)).testEquals();
    }
}