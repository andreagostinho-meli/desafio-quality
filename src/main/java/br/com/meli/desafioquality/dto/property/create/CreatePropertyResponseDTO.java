package br.com.meli.desafioquality.dto.property.create;

import br.com.meli.desafioquality.dto.property.RoomRequestDTO;

import java.math.BigDecimal;
import java.util.List;

public class CreatePropertyResponseDTO {
    private int prop_id;
    private String prop_name;
    private String prop_district;
    private BigDecimal value_district_m2;
    private List<RoomRequestDTO> rooms;

    public CreatePropertyResponseDTO(int prop_id, String prop_name, String prop_district, BigDecimal value_district_m2, List<RoomRequestDTO> rooms) {
        this.prop_id = prop_id;
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.value_district_m2 = value_district_m2;
        this.rooms = rooms;
    }

    public int getProp_id() {
        return prop_id;
    }

    public void setProp_id(int prop_id) {
        this.prop_id = prop_id;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }

    public List<RoomRequestDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomRequestDTO> rooms) {
        this.rooms = rooms;
    }
}
