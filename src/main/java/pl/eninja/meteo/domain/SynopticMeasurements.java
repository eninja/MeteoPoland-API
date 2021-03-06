package pl.eninja.meteo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class SynopticMeasurements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FOREIGN_ID")
    private int foreignId;
    private String city;
    private LocalDateTime saveDate;
    private double temperature;
    @Column(name = "WIND_SPEED")
    private double windSpeed;
    @Column(name = "AIR_HUMIDITY")
    private double airHumidity;
    private double pressure;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATION_ID")
    private MeasuringStation measuringStation;

    public SynopticMeasurements() {
    }

    private SynopticMeasurements(Builder builder) {
        this.foreignId = builder.foreignId;
        this.city = builder.city;
        this.saveDate = builder.saveDate;
        this.temperature = builder.temperature;
        this.windSpeed = builder.windSpeed;
        this.airHumidity = builder.airHumidity;
        this.pressure = builder.pressure;
        this.measuringStation = builder.measuringStation;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, foreignId, city, temperature, windSpeed, airHumidity, pressure, measuringStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SynopticMeasurements that = (SynopticMeasurements) o;
        return foreignId == that.foreignId && Double.compare(that.temperature,
                                                             temperature) == 0 && Double.compare(that.windSpeed,
                                                                                                 windSpeed) == 0 && Double
                .compare(that.airHumidity, airHumidity) == 0 && Double.compare(that.pressure,
                                                                               pressure) == 0 && Objects.equals(id,
                                                                                                                that.id) && Objects
                .equals(city, that.city) && Objects.equals(measuringStation, that.measuringStation);
    }

    @Override
    public String toString() {
        return "SynopticMeasurement id: " + id + ", foreign id=" + foreignId + ", save date: " + saveDate + "\n" + ", temperature: " + temperature + ", windSpeed: " + windSpeed + "\n" + ", airHumidity: " + airHumidity + ", pressure: " + pressure + "\n" + "_____________________________" + "\n";
    }

    public Long getId() {
        return id;
    }

    public int getForeignId() {
        return foreignId;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getAirHumidity() {
        return airHumidity;
    }

    public double getPressure() {
        return pressure;
    }

    public MeasuringStation getMeasuringStation() {
        return measuringStation;
    }

    @JsonIgnore
    public void setMeasuringStation(MeasuringStation measuringStation) {
        this.measuringStation = measuringStation;
    }

    public static class Builder {
        private Long id;
        private int foreignId;
        private LocalDateTime saveDate;
        private String city;
        private double temperature;
        private double windSpeed;
        private double airHumidity;
        private double pressure;
        private MeasuringStation measuringStation;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder foreignId(int foreignId) {
            this.foreignId = foreignId;
            return this;
        }

        public Builder saveDate(LocalDateTime saveDate) {
            this.saveDate = saveDate;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder temperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder windSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Builder airHumidity(double airHumidity) {
            this.airHumidity = airHumidity;
            return this;
        }

        public Builder pressure(double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder measuringStation(MeasuringStation measuringStation) {
            this.measuringStation = measuringStation;
            return this;
        }

        public SynopticMeasurements build() {
            return new SynopticMeasurements(this);
        }
    }
}

