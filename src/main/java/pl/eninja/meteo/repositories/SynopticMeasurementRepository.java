package pl.eninja.meteo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eninja.meteo.domain.SynopticMeasurements;

import java.util.List;

public interface SynopticMeasurementRepository extends CrudRepository<SynopticMeasurements, Long> {
    List<SynopticMeasurements> findAll();
}
