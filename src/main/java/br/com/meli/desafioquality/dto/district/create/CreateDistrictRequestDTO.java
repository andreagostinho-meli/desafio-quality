package br.com.meli.desafioquality.dto.district.create;

import java.math.BigDecimal;

public class CreateDistrictRequestDTO {
    private String district_name;
    private BigDecimal value_district_m2;

    public CreateDistrictRequestDTO() {
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }
}
