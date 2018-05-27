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

    @Test
    public void airQualityIsModerateTest() {
        AirMeasurements expect = mockAirRepository.airMeasurements1().get(0);
        AirMeasurements result = airMeasurementMapper.mapToAirMeasurements(mockAirMeasurementsDto.airMeasurementsDtoForAirQuality()
                                                                                                 .get(0));
        assertEquals(expect, result);
    }

    @Test
    public void airQualityIsSufficientTest() {
        AirMeasurements expect = mockAirRepository.airMeasurements2().get(0);
        AirMeasurements result = airMeasurementMapper.mapToAirMeasurements(mockAirMeasurementsDto.airMeasurementsDtoForAirQuality()
                                                                                                 .get(1));
        assertEquals(expect, result);
    }

    @Test
    public void airQualityIsBadTest() {
        AirMeasurements expect = mockAirRepository.airMeasurements2().get(1);
        AirMeasurements result = airMeasurementMapper.mapToAirMeasurements(mockAirMeasurementsDto.airMeasurementsDtoForAirQuality()
                                                                                                 .get(2));
        assertEquals(expect, result);
    }

    @Test
    public void airQualityIsVeryBadTest() {
        AirMeasurements expect = mockAirRepository.airMeasurements2().get(2);
        AirMeasurements result = airMeasurementMapper.mapToAirMeasurements(mockAirMeasurementsDto.airMeasurementsDtoForAirQuality()
                                                                                                 .get(3));
        assertEquals(expect, result);
    }
}
