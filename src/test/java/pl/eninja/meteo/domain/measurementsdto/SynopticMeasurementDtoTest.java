package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.eninja.meteo.repositories.MockSynopticMeasurementsDtoRepository;

public class SynopticMeasurementDtoTest extends DtoTest<SynopticMeasurementDto> {
    private final MockSynopticMeasurementsDtoRepository repository = new MockSynopticMeasurementsDtoRepository();

    @Test
    public void equalsTest() {
        new EqualsTester().addEqualityGroup(repository.equalsList().get(0), repository.equalsList().get(1))
                          .testEquals();
    }

    @Override
    protected SynopticMeasurementDto getInstance() {
        return new SynopticMeasurementDto();
    }
}