package pl.eninja.meteo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eninja.meteo.domain.MeasuringStation;

import java.util.List;

public interface MeasuringStationRepository extends CrudRepository<MeasuringStation, Long> {
    boolean existsAllByStationId(int id);

    MeasuringStation findByStationId(int stationId);

    List<MeasuringStation> findAll();
}
