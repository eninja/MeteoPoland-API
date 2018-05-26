package pl.eninja.meteo.supplier;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MeasuringStationApiSupplierTest {

    @Test
    public void isAllMeasuringStationsApiAvailableTest() throws IOException {
        assertTrue(MonitorApi.isAvailable(MeasuringStationApiSupplier.allMeasuringStationsApi));
    }

    @Test
    public void isMeasurementsApiAvailableTest() throws IOException {
        String stationId = "52";
        assertTrue(MonitorApi.isAvailable(MeasuringStationApiSupplier.measurementsAdi + stationId));
    }
}