package com.aarfee.entities;

public class CoderEntity {
    private int id;
    private String documentation;
    private String name;
    private String lastName;
    private String clan;

    public CoderEntity() {}

    public CoderEntity(int id, String documentation, String name, String lastName, String clan) {
        this.id = id;
        this.documentation = documentation;
        this.name = name;
        this.lastName = lastName;
        this.clan = clan;
    }

    public CoderEntity(String documentation, String name, String lastName, String clan) {
        this.documentation = documentation;
        this.name = name;
        this.lastName = lastName;
        this.clan = clan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "CoderEntity = " +
                "id: " + id +
                ", documentation: " + this.documentation + '\'' +
                ", name: " + this.name + '\'' +
                ", lastName: " + this.lastName + '\'' +
                ", clan: " + this.clan;
    }
}
