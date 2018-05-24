package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.MeasuringStation;

import java.util.ArrayList;
import java.util.List;

public class MockMeasuringStation {

    public List<MeasuringStation> equalsList() {
        MeasuringStation station1 = new MeasuringStation();
        station1.setCity("city");
        station1.setLatitude("latitude");
        station1.setLongitude("longitude");
        station1.setStationId(1);
        station1.setStationName("station");
        MeasuringStation station2 = new MeasuringStation();
        station2.setCity("city");
        station2.setLatitude("latitude");
        station2.setLongitude("longitude");
        station2.setStationId(1);
        station2.setStationName("station");
        List<MeasuringStation> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        return stations;
    }
}
