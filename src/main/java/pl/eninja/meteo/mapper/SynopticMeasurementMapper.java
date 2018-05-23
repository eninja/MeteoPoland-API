package pl.eninja.meteo.mapper;

import org.springframework.stereotype.Component;
import pl.eninja.meteo.domain.SynopticMeasurements;
import pl.eninja.meteo.domain.measurementsdto.SynopticMeasurementDto;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class SynopticMeasurementMapper {

    public SynopticMeasurements maptToSynopticMeasurement(SynopticMeasurementDto synDto) {
        SynopticMeasurementDto synMeasurements = Optional.ofNullable(synDto).orElse(emptyObj());
        LocalDateTime currentDate = LocalDateTime.now();
        return new SynopticMeasurements.SynopticMeasurementsBuilder().foreignId(synMeasurements.getId())
                                                                     .city(synMeasurements.getCity())
                                                                     .saveDate(currentDate)
                                                                     .temperature(synMeasurements.getTemperature())
                                                                     .windSpeed(synMeasurements.getWindSpeed())
                                                                     .airHumidity(synMeasurements.getAirHumidity())
                                                                     .pressure(synMeasurements.getPressure())
                                                                     .build();
    }

    private SynopticMeasurementDto emptyObj() {
        return new SynopticMeasurementDto(9999, "->>no data available<<-", 9999.0, 9999.0, 9999.0, 9999.0);
    }
}
