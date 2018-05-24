package pl.eninja.meteo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STATION_DETAILS")
public class MeasuringStationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String commune;
    private String district;
    private String voivodeship;

    public MeasuringStationDetails() {
    }

    private MeasuringStationDetails(Builder builder) {
        this.city = builder.city;
        this.commune = builder.commune;
        this.district = builder.district;
        this.voivodeship = builder.voivodeship;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, city, commune, district, voivodeship);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MeasuringStationDetails that = (MeasuringStationDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(city, that.city) && Objects.equals(commune,
                                                                                                that.commune) && Objects
                .equals(district, that.district) && Objects.equals(voivodeship, that.voivodeship);
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCommune() {
        return commune;
    }

    public String getDistrict() {
        return district;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public static class Builder {
        private Long id;
        private String city;
        private String commune;
        private String district;
        private String voivodeship;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder commune(String commune) {
            this.commune = commune;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder voivodeship(String voivodeship) {
            this.voivodeship = voivodeship;
            return this;
        }

        public MeasuringStationDetails build() {
            return new MeasuringStationDetails(this);
        }
    }
}
