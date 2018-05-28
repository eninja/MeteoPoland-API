package pl.eninja.meteo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.domain.MeasurementsAirLevel;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.domain.SynopticMeasurements;
import pl.eninja.meteo.repositories.Converter;
import pl.eninja.meteo.repositories.MockAirMeasurementsRepository;
import pl.eninja.meteo.repositories.MockStationRepository;
import pl.eninja.meteo.repositories.MockSynopticMeasurementsRepository;
import pl.eninja.meteo.services.GetMeasurementsService;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GetMeasurementsControllerTest {
    private final static String MAPPING = "/get";
    private final MockStationRepository mockStationRepository = new MockStationRepository();
    private final MockAirMeasurementsRepository mockAirRepository = new MockAirMeasurementsRepository();
    private final MockSynopticMeasurementsRepository mockSynopticMeasurementsRepository = new MockSynopticMeasurementsRepository();
    private final Converter converter = new Converter();
    @InjectMocks
    private GetMeasurementsController controller;

    @Mock
    private GetMeasurementsService service;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testFindAll() throws Exception {
        List<MeasuringStation> stations = mockStationRepository.stations();
        Mockito.when(service.findAll()).thenReturn(stations);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/stations/all"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(stations)));
    }

    @Test
    public void testfindAllAirMeasurementsByDate() throws Exception {
        List<AirMeasurements> airMeasurementsList = mockAirRepository.airMeasurements1();
        Mockito.when((service.getAirMeasurements("2018-05-05"))).thenReturn(airMeasurementsList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/date").param("date", "2018-05-05"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(airMeasurementsList)));
    }

    @Test
    public void testFindAHottestPlaceByDate() throws Exception {
        SynopticMeasurements synopticMeasurement = mockSynopticMeasurementsRepository.equalsList().get(0);
        Mockito.when(service.getHottestPlaceGivenDate("2018-05-05")).thenReturn(synopticMeasurement);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/hottest").param("date", "2018-05-05"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(synopticMeasurement)));
    }

    @Test
    public void testFindColdestPlaceByDate() throws Exception {
        SynopticMeasurements synopticMeasurements = mockSynopticMeasurementsRepository.synopticMeasurements2().get(0);
        Mockito.when(service.getColdestPlaceGivenDate("2018-05-05")).thenReturn(synopticMeasurements);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/coldest").param("date", "2018-05-05"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(synopticMeasurements)));
    }

    @Test
    public void testFindPlaceByAirQuality() throws Exception {
        List<AirMeasurements> airMeasurementsList = mockAirRepository.airMeasurements1();
        Mockito.when(service.getAirMeasurements(MeasurementsAirLevel.BAD)).thenReturn(airMeasurementsList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/air").param("airLevel", "BAD"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(airMeasurementsList)));
    }

    @Test
    public void testfindAllSynopticMeasurementsByDate() throws Exception {
        List<SynopticMeasurements> synopticMeasurements = mockSynopticMeasurementsRepository.synopticMeasurements2();
        Mockito.when((service.getSynopticMeasurements("2018-05-11"))).thenReturn(synopticMeasurements);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/synoptic").param("date", "2018-05-11"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(synopticMeasurements)));
    }

    @Test
    public void testFindColdest10Places() throws Exception {
        List<SynopticMeasurements> measurementsList = mockSynopticMeasurementsRepository.synopticMeasurements2();
        Mockito.when(service.getColdestPlaces()).thenReturn(measurementsList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/coldestTop"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(measurementsList)));
    }

    @Test
    public void testFindHottest10Places() throws Exception {
        List<SynopticMeasurements> measurementsList = mockSynopticMeasurementsRepository.synopticMeasurements2();
        Mockito.when(service.getHottestPlaces()).thenReturn(measurementsList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/measurements/hottestTop"))
               .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(measurementsList)));
    }
}