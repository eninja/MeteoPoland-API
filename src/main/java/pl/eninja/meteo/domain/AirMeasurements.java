package pl.eninja.meteo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AirMeasurements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FOREIGN_ID")
    private int foreignId;
    @Column(name = "MEASUREMENT_DATE")
    private LocalDateTime measurementDate;
    @Column(name = "SAVE_DATE")
    private LocalDateTime saveDate;
    @Enumerated(value = EnumType.STRING)
    private MeasurementsAirLevel airQuality;
    private String stIndexLevel;
    private String so2IndexLevel;
    private String no2IndexLevel;
    private String coIndexLevel;
    private String pm10IndexLevel;
    private String pm25IndexLevel;
    private String o3IndexLevel;
    private String c6h6IndexLevel;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "STATION_ID")
    private MeasuringStation measuringStation;

    public AirMeasurements() {
    }

    private AirMeasurements(Builder builder) {
        this.foreignId = builder.foreignId;
        this.measurementDate = builder.measurementDate;
        this.saveDate = builder.saveDate;
        this.airQuality = builder.airQuality;
        this.stIndexLevel = builder.stIndexLevel;
        this.so2IndexLevel = builder.so2IndexLevel;
        this.no2IndexLevel = builder.no2IndexLevel;
        this.coIndexLevel = builder.coIndexLevel;
        this.pm10IndexLevel = builder.pm10IndexLevel;
        this.pm25IndexLevel = builder.pm25IndexLevel;
        this.o3IndexLevel = builder.o3IndexLevel;
        this.c6h6IndexLevel = builder.c6h6IndexLevel;
        this.measuringStation = builder.measuringStation;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id,
                            foreignId,
                            measurementDate,
                            airQuality,
                            stIndexLevel,
                            so2IndexLevel,
                            no2IndexLevel,
                            coIndexLevel,
                            pm10IndexLevel,
                            pm25IndexLevel,
                            o3IndexLevel,
                            c6h6IndexLevel,
                            measuringStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AirMeasurements that = (AirMeasurements) o;
        return foreignId == that.foreignId && Objects.equals(id, that.id) && Objects.equals(measurementDate,
                                                                                            that.measurementDate) && airQuality == that.airQuality && Objects
                .equals(stIndexLevel, that.stIndexLevel) && Objects.equals(so2IndexLevel, that.so2IndexLevel) && Objects
                .equals(no2IndexLevel, that.no2IndexLevel) && Objects.equals(coIndexLevel, that.coIndexLevel) && Objects
                .equals(pm10IndexLevel, that.pm10IndexLevel) && Objects.equals(pm25IndexLevel,
                                                                               that.pm25IndexLevel) && Objects.equals(
                o3IndexLevel,
                that.o3IndexLevel) && Objects.equals(c6h6IndexLevel, that.c6h6IndexLevel) && Objects.equals(
                measuringStation,
                that.measuringStation);
    }

    @Override
    public String toString() {
        return "AirMeasurements: " + "id: " + id + ", Station id: " + foreignId + ", measurementDate: " + measurementDate + "\n, saveDate: " + saveDate + ", airQuality: " + airQuality + "\n" + ", stIndexLevel: " + stIndexLevel + ", so2IndexLevel: " + so2IndexLevel + "\n" + ", no2IndexLevel: " + no2IndexLevel + ", coIndexLevel: " + coIndexLevel + "\n" + ", pm10IndexLevel: " + pm10IndexLevel + ", pm25IndexLevel: " + pm25IndexLevel + "\n" + ", o3IndexLevel: " + o3IndexLevel + ", c6h6IndexLevel: " + c6h6IndexLevel + "\n" + "_____________________________" + "\n";
    }

    public Long getId() {
        return id;
    }

    public int getForeignId() {
        return foreignId;
    }

    public LocalDateTime getMeasurementDate() {
        return measurementDate;
    }

    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    public MeasurementsAirLevel getAirQuality() {
        return airQuality;
    }

    public String getStIndexLevel() {
        return stIndexLevel;
    }

    public String getSo2IndexLevel() {
        return so2IndexLevel;
    }

    public String getNo2IndexLevel() {
        return no2IndexLevel;
    }

    public String getCoIndexLevel() {
        return coIndexLevel;
    }

    public String getPm10IndexLevel() {
        return pm10IndexLevel;
    }

    public String getPm25IndexLevel() {
        return pm25IndexLevel;
    }

    public String getO3IndexLevel() {
        return o3IndexLevel;
    }

    public String getC6h6IndexLevel() {
        return c6h6IndexLevel;
    }

    @JsonIgnore
    public MeasuringStation getMeasuringStation() {
        return measuringStation;
    }

    public void setMeasuringStation(MeasuringStation measuringStation) {
        this.measuringStation = measuringStation;
    }

    public static class Builder {
        private Long id;
        private int foreignId;
        private LocalDateTime measurementDate;
        private LocalDateTime saveDate;
        private MeasurementsAirLevel airQuality;
        private String stIndexLevel;
        private String so2IndexLevel;
        private String no2IndexLevel;
        private String coIndexLevel;
        private String pm10IndexLevel;
        private String pm25IndexLevel;
        private String o3IndexLevel;
        private String c6h6IndexLevel;
        private MeasuringStation measuringStation;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder foreignId(int foreignId) {
            this.foreignId = foreignId;
            return this;
        }

        public Builder measurementDate(LocalDateTime measurementDate) {
            this.measurementDate = measurementDate;
            return this;
        }

        public Builder saveDate(LocalDateTime saveDate) {
            this.saveDate = saveDate;
            return this;
        }

        public Builder airQuality(MeasurementsAirLevel airQuality) {
            this.airQuality = airQuality;
            return this;
        }

        public Builder stIndexLevel(String stIndexLevel) {
            this.stIndexLevel = stIndexLevel;
            return this;
        }

        public Builder so2IndexLevel(String so2IndexLevel) {
            this.so2IndexLevel = so2IndexLevel;
            return this;
        }

        public Builder no2IndexLevel(String no2IndexLevel) {
            this.no2IndexLevel = no2IndexLevel;
            return this;
        }

        public Builder coIndexLevel(String coIndexLevel) {
            this.coIndexLevel = coIndexLevel;
            return this;
        }

        public Builder pm10IndexLevel(String pm10IndexLevel) {
            this.pm10IndexLevel = pm10IndexLevel;
            return this;
        }

        public Builder pm25IndexLevel(String pm25IndexLevel) {
            this.pm25IndexLevel = pm25IndexLevel;
            return this;
        }

        public Builder o3IndexLevel(String o3IndexLevel) {
            this.o3IndexLevel = o3IndexLevel;
            return this;
        }

        public Builder c6h6IndexLevel(String c6h6IndexLevel) {
            this.c6h6IndexLevel = c6h6IndexLevel;
            return this;
        }

        public Builder measuringStation(MeasuringStation measuringStation) {
            this.measuringStation = measuringStation;
            return this;
        }

        public AirMeasurements build() {
            return new AirMeasurements(this);
        }
    }
}
