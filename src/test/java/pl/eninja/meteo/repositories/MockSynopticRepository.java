package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.SynopticMeasurements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockSynopticRepository {

    public List<SynopticMeasurements> equalsList() {
        LocalDateTime date = LocalDateTime.of(2018, 05, 05, 12, 01);
        SynopticMeasurements synopticMeasurements = new SynopticMeasurements.Builder().id(1L)
                                                                                      .foreignId(100)
                                                                                      .city("Warszawa")
                                                                                      .saveDate(date)
                                                                                      .temperature(6)
                                                                                      .windSpeed(35).airHumidity(77)
                                                                                      .pressure(999)
                                                                                      .build();

        SynopticMeasurements synopticMeasurements1 = new SynopticMeasurements.Builder().id(2L)
                                                                                       .foreignId(100)
                                                                                       .city("Warszawa")
                                                                                       .saveDate(date)
                                                                                       .temperature(6)
                                                                                       .windSpeed(35)
                                                                                       .airHumidity(77)
                                                                                       .pressure(999)
                                                                                       .build();

        List<SynopticMeasurements> synopticMeasurementsList = new ArrayList<>();
        synopticMeasurementsList.add(synopticMeasurements);
        synopticMeasurementsList.add(synopticMeasurements1);
        return synopticMeasurementsList;
    }

    public List<SynopticMeasurements> synopticMeasurements2() {
        LocalDateTime date = LocalDateTime.of(2018, 05, 11, 10, 20);
        SynopticMeasurements synopticMeasurements = new SynopticMeasurements.Builder().id(11L)
                                                                                      .foreignId(111)
                                                                                      .city("Szczecien1")
                                                                                      .saveDate(date).temperature(28)
                                                                                      .windSpeed(15).airHumidity(16)
                                                                                      .pressure(1001)
                                                                                      .build();

        SynopticMeasurements synopticMeasurements1 = new SynopticMeasurements.Builder().id(12L)
                                                                                       .foreignId(112)
                                                                                       .city("Szczecin2")
                                                                                       .saveDate(date)
                                                                                       .temperature(22)
                                                                                       .windSpeed(11)
                                                                                       .airHumidity(16)
                                                                                       .pressure(999)
                                                                                       .build();

        SynopticMeasurements synopticMeasurements2 = new SynopticMeasurements.Builder().id(3L)
                                                                                       .foreignId(133)
                                                                                       .city("Szczecin3")
                                                                                       .saveDate(date)
                                                                                       .temperature(19)
                                                                                       .windSpeed(11)
                                                                                       .airHumidity(26)
                                                                                       .pressure(999)
                                                                                       .build();

        List<SynopticMeasurements> synopticMeasurementsList = new ArrayList<>();
        synopticMeasurementsList.add(synopticMeasurements);
        synopticMeasurementsList.add(synopticMeasurements1);
        synopticMeasurementsList.add(synopticMeasurements2);
        return synopticMeasurementsList;
    }
}
