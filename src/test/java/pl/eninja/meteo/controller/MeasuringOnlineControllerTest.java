package pl.eninja.meteo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.eninja.meteo.domain.MeasuringStationOnLine;
import pl.eninja.meteo.repositories.Converter;
import pl.eninja.meteo.repositories.MockMeasuringStationOnLine;
import pl.eninja.meteo.services.MeasuringOnlineServices;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MeasuringOnlineControllerTest {

    private final static String MAPPING = "/online";
    private final MockMeasuringStationOnLine mockMeasuringStationOnLine = new MockMeasuringStationOnLine();
    private final Converter converter = new Converter();
    @InjectMocks
    private MeasuringOnlineController measuringOnlineController;

    @Mock
    private MeasuringOnlineServices measuringOnlineServices;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(measuringOnlineController).build();
    }

    @Test
    public void getAllMeasuringStationsWithSynopticDataControllerTest() throws Exception {
        List<MeasuringStationOnLine> stationOnLineList = mockMeasuringStationOnLine.equalList();
        when(measuringOnlineServices.getAllMeasuringStations()).thenReturn(stationOnLineList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/stations/all"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(stationOnLineList)));
    }

    @Test
    public void getGivenCityMeasuringStationsWithSynopticDataControllerTest() throws Exception {
        List<MeasuringStationOnLine> stationOnLines = mockMeasuringStationOnLine.equalList();
        when(measuringOnlineServices.getGivenCityMeasuringStationsWithSynopticData("wawa")).thenReturn(stationOnLines);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/stations/select").param("city", "wawa"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(stationOnLines)));
    }

    @Test
    public void getHottestOnlineStationTest() throws Exception {
        MeasuringStationOnLine stationOnLine = mockMeasuringStationOnLine.equalList().get(0);
        when(measuringOnlineServices.getHottestOnlineStation()).thenReturn(stationOnLine);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/stations/hottest"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(stationOnLine)));
    }

    @Test
    public void getColdestOnlineStationTest() throws Exception {
        MeasuringStationOnLine stationOnLine = mockMeasuringStationOnLine.equalList().get(0);
        when(measuringOnlineServices.getColdestOnlineStation()).
                                                                       thenReturn(stationOnLine);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/stations/coldest"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(stationOnLine)));
    }
}