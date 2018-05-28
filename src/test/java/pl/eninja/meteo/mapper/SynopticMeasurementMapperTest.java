package pl.eninja.meteo.mapper;

import org.junit.Test;
import pl.eninja.meteo.domain.SynopticMeasurements;
import pl.eninja.meteo.repositories.MockSynopticMeasurementsDtoRepository;
import pl.eninja.meteo.repositories.MockSynopticMeasurementsRepository;

import static org.junit.Assert.assertEquals;

public class SynopticMeasurementMapperTest {
    private final MockSynopticMeasurementsDtoRepository dtoRepository = new MockSynopticMeasurementsDtoRepository();
    private final MockSynopticMeasurementsRepository repository = new MockSynopticMeasurementsRepository();
    private final SynopticMeasurementMapper mapper = new SynopticMeasurementMapper();

    @Test
    public void maptToSynopticMeasurement() {
        SynopticMeasurements expected = repository.mockMapper();
        SynopticMeasurements result = mapper.maptToSynopticMeasurement(dtoRepository.equalsList().get(0));
        assertEquals(expected, result);
    }
}