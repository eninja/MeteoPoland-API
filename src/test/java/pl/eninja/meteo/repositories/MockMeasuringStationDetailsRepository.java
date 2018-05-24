package pl.eninja.meteo.repositories;

import pl.eninja.meteo.domain.MeasuringStationDetails;

import java.util.ArrayList;
import java.util.List;

public class MockMeasuringStationDetailsRepository {

    public List<MeasuringStationDetails> equalsList() {
        MeasuringStationDetails station1 = new MeasuringStationDetails.Builder().id(1L)
                                                                                .city("Warszawa")
                                                                                .commune("commune")
                                                                                .district("district")
                                                                                .voivodeship("voivodeship")
                                                                                .build();
        MeasuringStationDetails station2 = new MeasuringStationDetails.Builder().id(1L)
                                                                                .city("Warszawa")
                                                                                .commune("commune")
                                                                                .district("district")
                                                                                .voivodeship("voivodeship")
                                                                                .build();

        List<MeasuringStationDetails> stationDetailsList = new ArrayList<>();
        stationDetailsList.add(station1);
        stationDetailsList.add(station2);
        return stationDetailsList;
    }
}