package pl.eninja.meteo.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.eninja.meteo.domain.MeasuringStationOnLine;
import pl.eninja.meteo.repositories.MockMeasuringStationOnLine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OnlineServicesTestSuit {
    private final MockMeasuringStationOnLine mockMeasuringStationOnLine = new MockMeasuringStationOnLine();
    @InjectMocks
    private MeasuringOnlineServicesImpl service;

    @Mock
    private MeasurementStationProcessor msProcessor;

    @Before
    public void init() {
        when(msProcessor.fillMeasuringStationListStructure()).thenReturn(mockMeasuringStationOnLine.resultForOnlineService());
    }

    @Test
    public void testGetAllMeasuringStations() {
        int result = service.getAllMeasuringStations().size();
        int expect = 3;
        assertEquals(expect, result);
    }

    @Test
    public void getGivenCityMeasuringStationsWithSynopticData() {
        int result = service.getGivenCityMeasuringStationsWithSynopticData("te").size();
        int expect = 2;
        assertEquals(expect, result);
    }

    @Test
    public void testgetHotestOnlineStation() {
        MeasuringStationOnLine result = service.getHottestOnlineStation();
        MeasuringStationOnLine expect = mockMeasuringStationOnLine.resultForOnlineService().get(0);
        assertEquals(expect, result);
    }

    @Test
    public void testgetHotestOnlineStation1() {
        MeasuringStationOnLine result = service.getHottestOnlineStation();
        MeasuringStationOnLine expect = mockMeasuringStationOnLine.resultForOnlineService().get(1);
        assertTrue(result.getStationName().contains(expect.getStationName()));
    }

    @Test
    public void testgetColdestOnlineStation() {
        MeasuringStationOnLine result = service.getColdestOnlineStation();
        MeasuringStationOnLine expect = mockMeasuringStationOnLine.resultForOnlineService().get(2);
        assertEquals(expect, result);
    }
}
