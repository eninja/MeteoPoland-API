package pl.eninja.meteo.mapper;

import org.junit.Test;
import pl.eninja.meteo.domain.MeasuringStationDetails;
import pl.eninja.meteo.repositories.MockMeasuringStationDetailsRepository;
import pl.eninja.meteo.repositories.MockMeasuringStationDtoRepository;

import static org.junit.Assert.assertEquals;

public class MeasuringStationDetailsMapperTest {
    private final MockMeasuringStationDtoRepository dtoRepository = new MockMeasuringStationDtoRepository();
    private final MockMeasuringStationDetailsRepository detailsRepository = new MockMeasuringStationDetailsRepository();
    private final MeasuringStationDetailsMapper detailsMapper = new MeasuringStationDetailsMapper();

    @Test
    public void testMapToAirMeasurements() {
        MeasuringStationDetails expect = detailsRepository.equalsList().get(0);
        MeasuringStationDetails result = detailsMapper.mapToStationDetails(dtoRepository.equalsList().get(0));
        assertEquals(expect, result);
    }
}