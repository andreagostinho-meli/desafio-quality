package br.com.meli.desafioquality.entities;

import java.math.BigDecimal;

public class District {
    private int id;
    private String name;
    private BigDecimal m2Value;

    public District(int id, String name, BigDecimal m2Value) {
        this.id = id;
        this.name = name;
        this.m2Value = m2Value;
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

    public BigDecimal getM2Value() {
        return m2Value;
    }

    public void setM2Value(BigDecimal m2Value) {
        this.m2Value = m2Value;
    }
}
