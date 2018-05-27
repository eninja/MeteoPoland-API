package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.measurementsdto.AirMeasurementsDto;
import pl.eninja.meteo.domain.measurementsdto.LevelDto;

import java.util.ArrayList;
import java.util.List;

public class MockAirMeasurementsDto {

    public AirMeasurementsDto airMeasurementsDto() {
        LevelDto stIndexLevel = new LevelDto.Builder().indexLevelName("stILevel").id(1).build();

        LevelDto so2IndexLevel = new LevelDto.Builder().indexLevelName("so2LEVEL").id(0).build();

        LevelDto no2IndexLevel = new LevelDto.Builder().indexLevelName("noLEVEL").id(0).build();

        LevelDto coIndexLevel = new LevelDto.Builder().indexLevelName("coLEVEL").id(0).build();

        LevelDto pm10IndexLevel = new LevelDto.Builder().indexLevelName("pm10LEVEL").id(0).build();

        LevelDto pm25IndexLevel = new LevelDto.Builder().indexLevelName("pm25LEVEL").id(0).build();

        LevelDto o3IndexLevel = new LevelDto.Builder().indexLevelName("o3LEVEL").id(0).build();

        LevelDto c6h6IndexLevel = new LevelDto.Builder().indexLevelName("c6hLEVEL").id(0).build();

        AirMeasurementsDto airMeasurementsDto = new AirMeasurementsDto();
        airMeasurementsDto.setStIndexLevel(stIndexLevel);
        airMeasurementsDto.setSo2IndexLevel(so2IndexLevel);
        airMeasurementsDto.setNo2IndexLevel(no2IndexLevel);
        airMeasurementsDto.setCoIndexLevel(coIndexLevel);
        airMeasurementsDto.setPm10IndexLevel(pm10IndexLevel);
        airMeasurementsDto.setPm25IndexLevel(pm25IndexLevel);
        airMeasurementsDto.setO3IndexLevel(o3IndexLevel);
        airMeasurementsDto.setC6h6IndexLevel(c6h6IndexLevel);
        airMeasurementsDto.setStCalcDate("2018-05-12 12:05:01:05");
        airMeasurementsDto.setSo2SourceDataDate("2018-05-05 12:01:05");
        airMeasurementsDto.setStCalcDate("2018-05-05 12:01:05");
        airMeasurementsDto.setId(1);
        return airMeasurementsDto;
    }

    public List<AirMeasurementsDto> airMeasurementsDtoForAirQuality() {
        LevelDto stIndexLevel = new LevelDto.Builder().indexLevelName("stILevel").id(1).build();
        LevelDto so2IndexLevel = new LevelDto.Builder().indexLevelName("so2LEVEL").id(2).build();
        LevelDto no2IndexLevel = new LevelDto.Builder().indexLevelName("noLEVEL").id(0).build();
        LevelDto coIndexLevel = new LevelDto.Builder().indexLevelName("coLEVEL").id(0).build();
        LevelDto pm10IndexLevel = new LevelDto.Builder().indexLevelName("pm10LEVEL").id(0).build();
        LevelDto pm25IndexLevel = new LevelDto.Builder().indexLevelName("pm25LEVEL").id(0).build();
        LevelDto o3IndexLevel = new LevelDto.Builder().indexLevelName("o3LEVEL").id(0).build();
        LevelDto c6h6IndexLevel = new LevelDto.Builder().indexLevelName("c6hLEVEL").id(0).build();

        final String calcDate = "2018-05-12 12:05:01:05";
        final String date = "2018-05-05 12:01:05";
        List<AirMeasurementsDto> list = new ArrayList<>();
        AirMeasurementsDto moderate = new AirMeasurementsDto();
        moderate.setStIndexLevel(stIndexLevel);
        moderate.setSo2IndexLevel(so2IndexLevel);
        moderate.setNo2IndexLevel(no2IndexLevel);
        moderate.setCoIndexLevel(coIndexLevel);
        moderate.setPm10IndexLevel(pm10IndexLevel);
        moderate.setPm25IndexLevel(pm25IndexLevel);
        moderate.setO3IndexLevel(o3IndexLevel);
        moderate.setC6h6IndexLevel(c6h6IndexLevel);
        moderate.setStCalcDate(calcDate);
        moderate.setSo2SourceDataDate(date);
        moderate.setStCalcDate(date);
        moderate.setId(1);
        AirMeasurementsDto sufficient = new AirMeasurementsDto();
        sufficient.setStIndexLevel(stIndexLevel);
        sufficient.setSo2IndexLevel(so2IndexLevel);
        sufficient.setNo2IndexLevel(no2IndexLevel);
        LevelDto pm10IndexLevelSufficient = new LevelDto.Builder().indexLevelName("pm10LEVEL").id(3).build();
        sufficient.setCoIndexLevel(coIndexLevel);
        sufficient.setPm10IndexLevel(pm10IndexLevelSufficient);
        sufficient.setPm25IndexLevel(pm25IndexLevel);
        sufficient.setO3IndexLevel(o3IndexLevel);
        sufficient.setC6h6IndexLevel(c6h6IndexLevel);
        sufficient.setStCalcDate(calcDate);
        sufficient.setSo2SourceDataDate(date);
        sufficient.setStCalcDate(date);
        sufficient.setId(1);
        AirMeasurementsDto bad = new AirMeasurementsDto();
        bad.setStIndexLevel(stIndexLevel);
        bad.setSo2IndexLevel(so2IndexLevel);
        bad.setNo2IndexLevel(no2IndexLevel);
        bad.setCoIndexLevel(coIndexLevel);
        bad.setPm10IndexLevel(pm10IndexLevel);
        LevelDto pm25IndexLevelBad = new LevelDto.Builder().indexLevelName("pm25LEVEL").id(4).build();
        bad.setPm25IndexLevel(pm25IndexLevelBad);
        bad.setO3IndexLevel(o3IndexLevel);
        bad.setC6h6IndexLevel(c6h6IndexLevel);
        bad.setStCalcDate(calcDate);
        bad.setSo2SourceDataDate(date);
        bad.setStCalcDate(date);
        bad.setId(1);
        AirMeasurementsDto veryBad = new AirMeasurementsDto();
        veryBad.setStIndexLevel(stIndexLevel);
        veryBad.setSo2IndexLevel(so2IndexLevel);
        LevelDto no2IndexLevelVeryBad = new LevelDto.Builder().indexLevelName("noLEVEL").id(5).build();
        veryBad.setNo2IndexLevel(no2IndexLevelVeryBad);
        veryBad.setCoIndexLevel(coIndexLevel);
        veryBad.setPm10IndexLevel(pm10IndexLevel);
        veryBad.setPm25IndexLevel(pm25IndexLevel);
        veryBad.setO3IndexLevel(o3IndexLevel);
        veryBad.setC6h6IndexLevel(c6h6IndexLevel);
        veryBad.setStCalcDate(calcDate);
        veryBad.setSo2SourceDataDate(date);
        veryBad.setStCalcDate(date);
        veryBad.setId(1);
        list.add(moderate);
        list.add(sufficient);
        list.add(bad);
        list.add(veryBad);
        return list;
    }
}
