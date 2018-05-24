package pl.eninja.meteo.mapper;

import org.junit.Test;
import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.repositories.MockAirMeasurementsDto;
import pl.eninja.meteo.repositories.MockAirMeasurementsRepository;

import static org.junit.Assert.assertEquals;

public class AirMeasurementMapperTest {
    private final MockAirMeasurementsRepository mockAirRepository = new MockAirMeasurementsRepository();
    private final MockAirMeasurementsDto mockAirMeasurementsDto = new MockAirMeasurementsDto();
    private final AirMeasurementMapper airMeasurementMapper = new AirMeasurementMapper();

    @Test
    public void testMapToAirMeasurements() {
        AirMeasurements expect = mockAirRepository.airMeasurement();
        AirMeasurements result = airMeasurementMapper.mapToAirMeasurements(mockAirMeasurementsDto.airMeasurementsDto());
        assertEquals(expect, result);
    }
}
