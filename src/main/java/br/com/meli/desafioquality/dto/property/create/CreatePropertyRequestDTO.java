package br.com.meli.desafioquality.dto.property.create;

import br.com.meli.desafioquality.dto.property.RoomRequestDTO;

import java.util.List;

public class CreatePropertyRequestDTO {
    private String prop_name;
    private int prop_district_id;
    private List<RoomRequestDTO> rooms;

    public CreatePropertyRequestDTO() {
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public int getProp_district_id() {
        return prop_district_id;
    }

    public void setProp_district_id(int prop_district_id) {
        this.prop_district_id = prop_district_id;
    }

    public List<RoomRequestDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomRequestDTO> rooms) {
        this.rooms = rooms;
    }
}
