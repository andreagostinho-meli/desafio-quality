package br.com.meli.desafioquality.dto.property.getlargestroom;

import br.com.meli.desafioquality.entities.Room;

public class GetLargestRoomResponseDTO {

    Room largest_room;

    public GetLargestRoomResponseDTO(Room largest_room) {
        this.largest_room = largest_room;
    }

    public Room getLargest_room() {
        return largest_room;
    }

    public void setLargest_room(Room largest_room) {
        this.largest_room = largest_room;
    }

}
