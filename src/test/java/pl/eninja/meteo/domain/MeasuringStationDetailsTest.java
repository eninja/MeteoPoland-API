package pl.eninja.meteo.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class MeasuringStationDetailsTest {

    @Test
    public void equalsTest() {
        MeasuringStationDetails station1 = new MeasuringStationDetails.Builder().id(1L)
                                                                                .city("Warszawa")
                                                                                .commune("commune")
                                                                                .district("district")
                                                                                .voivodeship("voivodeship")
                                                                                .build();
        MeasuringStationDetails station2 = new MeasuringStationDetails.Builder().id(1L)
                                                                                .city("Warszawa")
                                                                                .commune("commune")
                                                                                .district("district")
                                                                                .voivodeship("voivodeship")
                                                                                .build();

        new EqualsTester().addEqualityGroup(station1, station2).testEquals();
    }
}