package br.com.meli.desafioquality.dto.property.gettotalm2;

public class GetPropertyTotalM2ResponseDTO {

    private double total_m2;

    public GetPropertyTotalM2ResponseDTO(double total_m2) {
        this.total_m2 = total_m2;
    }

    public double getTotal_m2() {
        return total_m2;
    }

    public void setTotal_m2(double total_m2) {
        this.total_m2 = total_m2;
    }
}
