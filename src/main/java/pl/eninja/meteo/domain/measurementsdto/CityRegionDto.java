package pl.eninja.meteo.domain.measurementsdto;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonClassDescription(value = "commune")
public class CityRegionDto {
    private String communeName;
    private String districtName;
    @JsonProperty("provinceName")
    private String voivodeship;

    public CityRegionDto() {
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCommuneName(), getDistrictName(), getVoivodeship());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CityRegionDto)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CityRegionDto that = (CityRegionDto) o;
        return Objects.equals(getCommuneName(), that.getCommuneName()) && Objects.equals(getDistrictName(),
                                                                                         that.getDistrictName()) && Objects
                .equals(getVoivodeship(), that.getVoivodeship());
    }

    @Override
    public String toString() {
        return "**CityRegionDto: \n communeName: " + communeName + ", districtName: " + districtName + ", voivodeship: " + voivodeship;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }
}
