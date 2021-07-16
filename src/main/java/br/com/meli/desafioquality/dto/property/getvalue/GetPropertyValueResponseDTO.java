package br.com.meli.desafioquality.dto.property.getvalue;

import java.math.BigDecimal;

public class GetPropertyValueResponseDTO {

    private BigDecimal value;

    public GetPropertyValueResponseDTO(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
