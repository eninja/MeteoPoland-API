package pl.eninja.meteo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.domain.MeasurementsAirLevel;

import java.util.List;

public interface AirMeasurementRepository extends CrudRepository<AirMeasurements, Long> {
    List<AirMeasurements> findAll();

    List<AirMeasurements> findAllByAirQuality(MeasurementsAirLevel measurementsAirLevel);
}
