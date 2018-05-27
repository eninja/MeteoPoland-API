package pl.eninja.meteo.services;

import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.domain.MeasurementsAirLevel;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.domain.SynopticMeasurements;

import java.util.List;

public interface GetMeasurementsService {
    List<MeasuringStation> findAll();

    List<AirMeasurements> getAirMeasurements(String date);

    List<AirMeasurements> getAirMeasurements(MeasurementsAirLevel measurementsAirLevel);

    List<SynopticMeasurements> getSynopticMeasurements(String date);

    SynopticMeasurements getHottestPlaceGivenDate(String date);

    SynopticMeasurements getColdestPlaceGivenDate(String date);

    List<SynopticMeasurements> getColdestPlaces();

    List<SynopticMeasurements> getHottestPlaces();
}
