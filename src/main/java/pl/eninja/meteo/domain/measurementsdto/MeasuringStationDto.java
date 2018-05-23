package pl.eninja.meteo.domain.measurementsdto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MeasuringStationDto {
    private int id;
    private String stationName;
    private String gegrLat;
    private String gegrLon;
    private String addressStreet;
    @JsonProperty("city")
    private CityDto cityDto;

    public MeasuringStationDto() {
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stationName, gegrLat, gegrLon, addressStreet, cityDto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MeasuringStationDto that = (MeasuringStationDto) o;
        return id == that.id && Objects.equals(stationName, that.stationName) && Objects.equals(gegrLat,
                                                                                                that.gegrLat) && Objects
                .equals(gegrLon, that.gegrLon) && Objects.equals(addressStreet, that.addressStreet) && Objects.equals(
                cityDto,
                that.cityDto);
    }

    @Override
    public String toString() {
        return "MeasuringStationDto: " + "id: " + id + "\n" + "  stationName: " + stationName + "\n" + "  geographic latitude: " + gegrLat + '\'' + "  geographic longitude: " + gegrLon + "\n" + "  addressStreet: " + addressStreet + "\n" + cityDto + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getGegrLat() {
        return gegrLat;
    }

    public void setGegrLat(String gegrLat) {
        this.gegrLat = gegrLat;
    }

    public String getGegrLon() {
        return gegrLon;
    }

    public void setGegrLon(String gegrLon) {
        this.gegrLon = gegrLon;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }
}

