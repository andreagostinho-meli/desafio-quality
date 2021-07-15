package br.com.meli.desafioquality.entities;

import java.util.List;

public class Property {
    private int id;
    private String name;
    private String district;
    private double valueDistrictM2;
    private List<Room> rooms;

    public Property(int id, String name, String district, double valueDistrictM2, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.valueDistrictM2 = valueDistrictM2;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getValueDistrictM2() {
        return valueDistrictM2;
    }

    public void setValueDistrictM2(double valueDistrictM2) {
        this.valueDistrictM2 = valueDistrictM2;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
