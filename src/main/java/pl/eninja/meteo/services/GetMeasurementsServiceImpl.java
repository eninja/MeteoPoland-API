package pl.eninja.meteo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.eninja.meteo.domain.AirMeasurements;
import pl.eninja.meteo.domain.MeasurementsAirLevel;
import pl.eninja.meteo.domain.MeasuringStation;
import pl.eninja.meteo.domain.SynopticMeasurements;
import pl.eninja.meteo.repositories.AirMeasurementRepository;
import pl.eninja.meteo.repositories.MeasuringStationRepository;
import pl.eninja.meteo.repositories.SynopticMeasurementRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetMeasurementsServiceImpl implements GetMeasurementsService {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final MeasuringStationRepository stationRepository;
    private final AirMeasurementRepository airRepository;
    private final SynopticMeasurementRepository synopticRepository;

    @Autowired
    public GetMeasurementsServiceImpl(MeasuringStationRepository stationRepository, AirMeasurementRepository airRepository, SynopticMeasurementRepository synopticRepository) {
        this.stationRepository = stationRepository;
        this.airRepository = airRepository;
        this.synopticRepository = synopticRepository;
    }

    @Override
    public List<MeasuringStation> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public List<AirMeasurements> getAirMeasurements(String date) {
        LocalDate localDate = LocalDate.parse(date, formatter);
        return airRepository.findAll()
                            .stream()
                            .filter(a -> a.getSaveDate().toLocalDate().isEqual(localDate))
                            .collect(Collectors.toList());
    }

    @Override
    public List<AirMeasurements> getAirMeasurements(MeasurementsAirLevel measurementsAirLevel) {
        return airRepository.findAllByAirQuality(measurementsAirLevel);
    }

    @Override
    public List<SynopticMeasurements> getSynopticMeasurements(String date) {
        LocalDate localDate = LocalDate.parse(date, formatter);
        return synopticRepository.findAll()
                                 .stream()
                                 .filter(a -> a.getSaveDate().toLocalDate().isEqual(localDate))
                                 .collect(Collectors.toList());
    }

    @Override
    public SynopticMeasurements getHottestPlaceGivenDate(String date) {
        LocalDate localDate = LocalDate.parse(date, formatter);

        return synopticRepository.findAll()
                                 .stream()
                                 .filter(a -> a.getTemperature() < 9999 && a.getSaveDate()
                                                                            .toLocalDate()
                                                                            .isEqual(localDate))
                                 .max(Comparator.comparing(SynopticMeasurements::getTemperature)
                                                .thenComparing(SynopticMeasurements::getAirHumidity)
                                                .reversed()
                                                .thenComparing(SynopticMeasurements::getWindSpeed)
                                                .reversed())
                                 .orElse(null);
    }

    @Override
    public SynopticMeasurements getColdestPlaceGivenDate(String date) {
        LocalDate localDate = LocalDate.parse(date, formatter);
        return synopticRepository.findAll()
                                 .stream()
                                 .filter(a -> a.getTemperature() < 9999 && a.getSaveDate()
                                                                            .toLocalDate()
                                                                            .isEqual(localDate))
                                 .min(Comparator.comparing(SynopticMeasurements::getTemperature)
                                                .thenComparing(SynopticMeasurements::getAirHumidity)
                                                .reversed()
                                                .thenComparing(SynopticMeasurements::getWindSpeed)
                                                .reversed())
                                 .orElse(null);
    }

    @Override
    public List<SynopticMeasurements> getColdestPlaces() {
        return synopticRepository.findAll()
                                 .stream()
                                 .filter(a -> a.getTemperature() < 9999)
                                 .sorted(Comparator.comparing(SynopticMeasurements::getTemperature)
                                                   .thenComparing(SynopticMeasurements::getAirHumidity)
                                                   .reversed()
                                                   .thenComparing(SynopticMeasurements::getWindSpeed)
                                                   .reversed())
                                 .collect(Collectors.toList());
    }

    @Override
    public List<SynopticMeasurements> getHottestPlaces() {
        return synopticRepository.findAll()
                                 .stream()
                                 .filter(a -> a.getTemperature() < 9999)
                                 .sorted(Comparator.comparing(SynopticMeasurements::getTemperature)
                                                   .reversed()
                                                   .thenComparing(SynopticMeasurements::getAirHumidity)
                                                   .thenComparing(SynopticMeasurements::getWindSpeed))
                                 .collect(Collectors.toList());
    }
}

