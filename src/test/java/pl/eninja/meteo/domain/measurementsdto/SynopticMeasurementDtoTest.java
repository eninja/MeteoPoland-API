package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class SynopticMeasurementDtoTest extends DtoTest<SynopticMeasurementDto> {
    @Test
    public void equalsTest() {
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
        new EqualsTester().addEqualityGroup(measurement1, measurement2).testEquals();
    }

    @Override
    protected SynopticMeasurementDto getInstance() {
        return new SynopticMeasurementDto();
    }
}