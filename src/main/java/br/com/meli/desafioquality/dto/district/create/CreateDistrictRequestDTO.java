package br.com.meli.desafioquality.dto.district.create;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CreateDistrictRequestDTO {
    @NotBlank(message = "O bairro não pode estar vazio")
    @Size(max = 45, message = "O nome do bairro não pode exceder 45 caracteres")
    private String district_name;

    @NotNull(message = "O valor do metro quadrado não pode estar vazio")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor do metro quadrado deve ser maior que zero")
    @Digits(integer = 13, fraction = 2, message = "O valor do metro quadrado não pode exceder 13 dígitos")
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
