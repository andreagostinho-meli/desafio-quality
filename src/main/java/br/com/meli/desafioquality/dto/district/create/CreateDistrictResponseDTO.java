package br.com.meli.desafioquality.dto.district.create;

import java.math.BigDecimal;

public class CreateDistrictResponseDTO {

    private int district_id;
    private String district_name;
    private BigDecimal value_district_m2;

    public CreateDistrictResponseDTO(int district_id, String district_name, BigDecimal value_district_m2) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.value_district_m2 = value_district_m2;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
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
