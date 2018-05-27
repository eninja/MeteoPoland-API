package pl.eninja.meteo.mapper;

import org.junit.Test;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.repositories.MockMeasuringStation;
import pl.eninja.meteo.repositories.MockMeasuringStationDtoRepository;

import static org.junit.Assert.assertEquals;

public class MeasuringStationMapperTest {
    private final MockMeasuringStationDtoRepository dtoRepository = new MockMeasuringStationDtoRepository();
    private final MockMeasuringStation mockMeasuringStation = new MockMeasuringStation();
    private final MeasuringStationMapper mapper = new MeasuringStationMapper();

    @Test
    public void mapToMeasuringSt() {
        MeasuringStation expected = mockMeasuringStation.mapperMeasuringStation();
        MeasuringStation result = mapper.mapToMeasuringSt(dtoRepository.mapperStationDto());
        assertEquals(expected, result);
    }
}