package pl.eninja.meteo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eninja.meteo.domain.MeasuringStationDetails;

public interface MeasuringStationDetailsRepository extends CrudRepository<MeasuringStationDetails, Long> {
}
