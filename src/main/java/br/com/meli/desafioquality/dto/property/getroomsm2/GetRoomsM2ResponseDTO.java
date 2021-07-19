package br.com.meli.desafioquality.dto.property.getroomsm2;

import java.util.List;

public class GetRoomsM2ResponseDTO {

    private List<RoomM2DTO> rooms;

    public GetRoomsM2ResponseDTO(List<RoomM2DTO> rooms) {
        this.rooms = rooms;
    }

    public List<RoomM2DTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomM2DTO> rooms) {
        this.rooms = rooms;
    }

}
