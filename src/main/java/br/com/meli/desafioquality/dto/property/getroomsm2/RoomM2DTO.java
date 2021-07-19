package br.com.meli.desafioquality.dto.property.getroomsm2;

public class RoomM2DTO {

    private String room_name;
    private double room_width;
    private double room_length;
    private double total_m2;

    public RoomM2DTO(String room_name, double room_width, double room_length, double total_m2) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
        this.total_m2 = total_m2;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(double room_width) {
        this.room_width = room_width;
    }

    public double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(double room_length) {
        this.room_length = room_length;
    }

    public double getTotal_m2() {
        return total_m2;
    }

    public void setTotal_m2(double total_m2) {
        this.total_m2 = total_m2;
    }

}
