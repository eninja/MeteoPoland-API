package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.domain.MeasurementsAirLevel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockAirMeasurementsRepository {

    public List<AirMeasurements> airMeasurements1() {
        LocalDateTime date = LocalDateTime.of(2018, 05, 05, 12, 01, 05);
        List<AirMeasurements> result = new ArrayList<>();
        AirMeasurements airMeasurements1 = new AirMeasurements.AirMaesurementsBuilder().id(1L)
                                                                                       .airQuality(MeasurementsAirLevel.GOOD)
                                                                                       .stIndexLevel("stILevel")
                                                                                       .c6h6IndexLevel("c6hLEVEL")
                                                                                       .coIndexLevel("coLEVEL")
                                                                                       .no2IndexLevel("noLEVEL")
                                                                                       .o3IndexLevel("o3LEVEL")
                                                                                       .pm10IndexLevel("pm10LEVEL")
                                                                                       .pm25IndexLevel("pm25LEVEL")
                                                                                       .so2IndexLevel("so2LEVEL")
                                                                                       .foreignId(1)
                                                                                       .measurementDate(date)
                                                                                       .saveDate(date)
                                                                                       .build();

        AirMeasurements airMeasurements2 = new AirMeasurements.AirMaesurementsBuilder().id(1L)
                                                                                       .airQuality(MeasurementsAirLevel.MODERATE)
                                                                                       .c6h6IndexLevel("c6hLEVEL")
                                                                                       .coIndexLevel("coLEVEL")
                                                                                       .no2IndexLevel("noLEVEL")
                                                                                       .o3IndexLevel("o3LEVEL")
                                                                                       .pm10IndexLevel("pm10LEVEL")
                                                                                       .pm25IndexLevel("pm25LEVEL")
                                                                                       .so2IndexLevel("so2LEVEL")
                                                                                       .foreignId(2)
                                                                                       .measurementDate(date)
                                                                                       .saveDate(date)
                                                                                       .build();
        AirMeasurements airMeasurements3 = new AirMeasurements.AirMaesurementsBuilder().id(1L)
                                                                                       .airQuality(MeasurementsAirLevel.GOOD)
                                                                                       .stIndexLevel("stILevel")
                                                                                       .c6h6IndexLevel("c6hLEVEL")
                                                                                       .coIndexLevel("coLEVEL")
                                                                                       .no2IndexLevel("noLEVEL")
                                                                                       .o3IndexLevel("o3LEVEL")
                                                                                       .pm10IndexLevel("pm10LEVEL")
                                                                                       .pm25IndexLevel("pm25LEVEL")
                                                                                       .so2IndexLevel("so2LEVEL")
                                                                                       .foreignId(1)
                                                                                       .measurementDate(date)
                                                                                       .saveDate(date)
                                                                                       .build();
        result.add(airMeasurements1);
        result.add(airMeasurements2);
        result.add(airMeasurements3);
        return result;
    }

    public List<AirMeasurements> airMeasurements2() {
        LocalDateTime date = LocalDateTime.of(2018, 05, 05, 12, 01, 05);
        List<AirMeasurements> result = new ArrayList<>();
        AirMeasurements airMeasurements3 = new AirMeasurements.AirMaesurementsBuilder().airQuality(MeasurementsAirLevel.SUFFICIENT)
                                                                                       .c6h6IndexLevel("c6hLEVEL")
                                                                                       .coIndexLevel("coLEVEL")
                                                                                       .stIndexLevel("stILevel")
                                                                                       .no2IndexLevel("noLEVEL")
                                                                                       .o3IndexLevel("o3LEVEL")
                                                                                       .pm10IndexLevel("pm10LEVEL")
                                                                                       .pm25IndexLevel("pm25LEVEL")
                                                                                       .so2IndexLevel("so2LEVEL")
                                                                                       .foreignId(1)
                                                                                       .measurementDate(date)
                                                                                       .saveDate(date)
                                                                                       .build();

        AirMeasurements airMeasurements4 = new AirMeasurements.AirMaesurementsBuilder().airQuality(MeasurementsAirLevel.BAD)
                                                                                       .c6h6IndexLevel("c6hLEVEL")
                                                                                       .coIndexLevel("coLEVEL")
                                                                                       .stIndexLevel("stILevel")
                                                                                       .no2IndexLevel("noLEVEL")
                                                                                       .o3IndexLevel("o3LEVEL")
                                                                                       .pm10IndexLevel("pm10LEVEL")
                                                                                       .pm25IndexLevel("pm25LEVEL")
                                                                                       .so2IndexLevel("so2LEVEL")
                                                                                       .foreignId(1)
                                                                                       .measurementDate(date)
                                                                                       .saveDate(date)
                                                                                       .build();
        AirMeasurements airMeasurements5 = new AirMeasurements.AirMaesurementsBuilder().airQuality(MeasurementsAirLevel.VERY_BAD)
                                                                                       .c6h6IndexLevel("c6hLEVEL")
                                                                                       .coIndexLevel("coLEVEL")
                                                                                       .stIndexLevel("stILevel")
                                                                                       .no2IndexLevel("noLEVEL")
                                                                                       .o3IndexLevel("o3LEVEL")
                                                                                       .pm10IndexLevel("pm10LEVEL")
                                                                                       .pm25IndexLevel("pm25LEVEL")
                                                                                       .so2IndexLevel("so2LEVEL")
                                                                                       .foreignId(1)
                                                                                       .measurementDate(date)
                                                                                       .saveDate(date)
                                                                                       .build();
        result.add(airMeasurements3);
        result.add(airMeasurements4);
        result.add(airMeasurements5);
        return result;
    }

    public AirMeasurements airMeasurement() {
        LocalDateTime date = LocalDateTime.of(2018, 05, 05, 12, 01, 05);
        LocalDateTime currentDate = LocalDateTime.now();
        return new AirMeasurements.AirMaesurementsBuilder().airQuality(MeasurementsAirLevel.GOOD)
                                                           .stIndexLevel("stILevel")
                                                           .c6h6IndexLevel("c6hLEVEL")
                                                           .coIndexLevel("coLEVEL")
                                                           .no2IndexLevel("noLEVEL")
                                                           .o3IndexLevel("o3LEVEL")
                                                           .pm10IndexLevel("pm10LEVEL")
                                                           .pm25IndexLevel("pm25LEVEL")
                                                           .so2IndexLevel("so2LEVEL")
                                                           .foreignId(1)
                                                           .measurementDate(date)
                                                           .saveDate(currentDate.withNano(0))
                                                           .build();
    }
}