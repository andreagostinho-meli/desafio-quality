package br.com.meli.desafioquality.entities;

import java.util.List;

public class Property {
    private int id;
    private String name;
    private int district_id;
    private List<Room> rooms;

    public Property(int id, String name, int district_id, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.district_id = district_id;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
