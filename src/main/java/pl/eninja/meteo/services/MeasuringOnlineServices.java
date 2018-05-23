package pl.eninja.meteo.services;

import pl.eninja.meteo.domain.MeasuringStationOnLine;

import java.util.List;

public interface MeasuringOnlineServices {
    List<MeasuringStationOnLine> getAllMeasuringStations();

    List<MeasuringStationOnLine> getGivenCityMeasuringStationsWithSynopticData(String cityName);

    MeasuringStationOnLine getHottestOnlineStation();

    MeasuringStationOnLine getColdestOnlineStation();

    void addAllStations();
}
