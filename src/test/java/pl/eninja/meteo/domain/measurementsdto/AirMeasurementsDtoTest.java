package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class AirMeasurementsDtoTest {

    @Test
    public void equalsTest() {
        AirMeasurementsDto dto1 = new AirMeasurementsDto();
        dto1.setId(1);
        dto1.setStCalcDate("calc");
        dto1.setStIndexLevel(new LevelDto());
        dto1.setSo2IndexLevel(new LevelDto());
        AirMeasurementsDto dto2 = new AirMeasurementsDto();
        dto2.setId(1);
        dto2.setStCalcDate("calc");
        dto2.setStIndexLevel(new LevelDto());
        dto2.setSo2IndexLevel(new LevelDto());
        new EqualsTester().addEqualityGroup(dto1, dto2).testEquals();
    }
}