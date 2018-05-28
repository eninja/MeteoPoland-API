package pl.eninja.meteo.mapper;

import org.junit.Test;
import pl.eninja.meteo.domain.MeasuringStationOnLine;
import pl.eninja.meteo.repositories.MockAirMeasurementsDto;
import pl.eninja.meteo.repositories.MockMeasuringStationDtoRepository;
import pl.eninja.meteo.repositories.MockMeasuringStationOnLine;
import pl.eninja.meteo.repositories.MockSynopticMeasurementsDtoRepository;

import static org.junit.Assert.assertEquals;

public class MeasuringStationOnLineMapperTest {
    private final MeasuringStationOnLineMapper mapper = new MeasuringStationOnLineMapper();
    private final MockMeasuringStationDtoRepository dtoRepository = new MockMeasuringStationDtoRepository();
    private final MockMeasuringStationOnLine repository = new MockMeasuringStationOnLine();
    private final MockAirMeasurementsDto airMeasurementsDto = new MockAirMeasurementsDto();
    private final MockSynopticMeasurementsDtoRepository synopticMeasurementsDtoRepository = new MockSynopticMeasurementsDtoRepository();

    @Test
    public void mapToMeasuringStationList() {
    }

    @Test
    public void mapToMeasuringStation() {
        MeasuringStationOnLine expected = repository.mapperObj();
        MeasuringStationOnLine result = mapper.mapToMeasuringStation(dtoRepository.mapperOnlineStationDto(),
                                                                     airMeasurementsDto.mapperOnline(),
                                                                     synopticMeasurementsDtoRepository.mapperOnline());
        assertEquals(expected, result);
    }
}