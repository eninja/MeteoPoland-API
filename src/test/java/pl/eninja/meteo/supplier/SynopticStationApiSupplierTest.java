package pl.eninja.meteo.supplier;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class SynopticStationApiSupplierTest {

    @Test
    public void isAllSynopticStationsDataApiAvailableTest() throws IOException {
        assertTrue(MonitorApi.isAvailable(SynopticStationApiSupplier.allSynopticStationsData));
    }
}