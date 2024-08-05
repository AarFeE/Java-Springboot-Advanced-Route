package com.aarfee.entities;

public class EnterpriseEntity {
    private int id;
    private String name;
    private String nit;

    public EnterpriseEntity() {}

    public EnterpriseEntity(int id, String name, String nit) {
        this.id = id;
        this.nit = nit;
        this.name = name;
    }

    public EnterpriseEntity(String name, String nit) {
        this.name = name;
        this.nit = nit;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "EnterpriseEntity = " +
                "id: " + id +
                ", name: " + name +
                ", nit: " + nit;
    }
}
