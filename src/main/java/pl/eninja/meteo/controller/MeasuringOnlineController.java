package pl.eninja.meteo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.eninja.meteo.domain.MeasuringStationOnLine;
import pl.eninja.meteo.services.MeasuringOnlineServices;

import java.util.List;

@Api(description = "Get measurements directly from API")
@RestController
@RequestMapping("/online")
public class MeasuringOnlineController {

    private final MeasuringOnlineServices measuringOnlineServices;

    @Autowired
    public MeasuringOnlineController(MeasuringOnlineServices measuringOnlineServices) {
        this.measuringOnlineServices = measuringOnlineServices;
    }

    @ApiOperation(value = "Get all stations")
    @RequestMapping(value = "/stations/all", method = RequestMethod.GET)
    public List<MeasuringStationOnLine> getAllMeasuringStationsWithSynopticDataController() {
        return measuringOnlineServices.getAllMeasuringStations();
    }

    @ApiOperation(value = "Get all measurements stations for given city name")
    @ApiImplicitParam(required = true, name = "city", value = "City name", dataType = "string", paramType = "query")
    @RequestMapping(value = "/stations/select", method = RequestMethod.GET)
    public List<MeasuringStationOnLine> getGivenCityMeasuringStationsWithSynopticDataController(String city) {
        return measuringOnlineServices.getGivenCityMeasuringStationsWithSynopticData(city);
    }

    @ApiOperation(value = "Get hottest station")
    @RequestMapping(value = "/stations/hottest", method = RequestMethod.GET)
    public MeasuringStationOnLine getHottestOnlineStation() {
        return measuringOnlineServices.getHottestOnlineStation();
    }

    @ApiOperation(value = "Get coldest station")
    @RequestMapping(value = "/stations/coldest", method = RequestMethod.GET)
    public MeasuringStationOnLine getColdestOnlineStation() {
        return measuringOnlineServices.getColdestOnlineStation();
    }
}

