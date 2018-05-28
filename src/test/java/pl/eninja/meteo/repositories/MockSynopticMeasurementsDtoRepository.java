package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.measurementsdto.SynopticMeasurementDto;

import java.util.ArrayList;
import java.util.List;

public class MockSynopticMeasurementsDtoRepository {
    public List<SynopticMeasurementDto> equalsList() {
        SynopticMeasurementDto measurement1 = new SynopticMeasurementDto();
        measurement1.setAirHumidity(12.12);
        measurement1.setCity("city");
        measurement1.setId(1);
        measurement1.setPressure(12.12);
        measurement1.setTemperature(22.22);
        measurement1.setWindSpeed(20);
        SynopticMeasurementDto measurement2 = new SynopticMeasurementDto();
        measurement2.setAirHumidity(12.12);
        measurement2.setCity("city");
        measurement2.setId(1);
        measurement2.setPressure(12.12);
        measurement2.setTemperature(22.22);
        measurement2.setWindSpeed(20);
        List<SynopticMeasurementDto> list = new ArrayList<>();
        list.add(measurement1);
        list.add(measurement2);
        return list;
    }

    public SynopticMeasurementDto mapperOnline() {
        SynopticMeasurementDto measurement1 = new SynopticMeasurementDto();
        measurement1.setAirHumidity(12.12);
        measurement1.setCity("city");
        measurement1.setId(1);
        measurement1.setPressure(12.12);
        measurement1.setTemperature(22.22);
        measurement1.setWindSpeed(20);
        return measurement1;
    }
}
