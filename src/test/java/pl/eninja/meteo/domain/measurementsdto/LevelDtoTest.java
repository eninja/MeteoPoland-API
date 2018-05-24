package pl.eninja.meteo.domain.measurementsdto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class LevelDtoTest extends DtoTest<LevelDto> {
    @Test
    public void equalsTest() {
        LevelDto dto1 = new LevelDto.Builder().id(1).indexLevelName("level").build();
        LevelDto dto2 = new LevelDto.Builder().id(1).indexLevelName("level").build();
        new EqualsTester().addEqualityGroup(dto1, dto2).testEquals();
    }

    @Override
    protected LevelDto getInstance() {
        return new LevelDto();
    }
}