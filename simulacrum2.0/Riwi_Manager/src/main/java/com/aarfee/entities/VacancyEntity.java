package com.aarfee.entities;

public class VacancyEntity {
    private int id;
    private String technology;
    private String description;
    private int enterpriseId;
    private boolean state;

    public VacancyEntity() {}

    public VacancyEntity(int id, String technology, String description, int enterpriseId, boolean state) {
        this.id = id;
        this.technology = technology;
        this.description = description;
        this.enterpriseId = enterpriseId;
        this.state = state;
    }

    public VacancyEntity(String technology, String description, int enterpriseId, boolean state) {
        this.technology = technology;
        this.description = description;
        this.enterpriseId = enterpriseId;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "VacancyModel = " +
                "id: " + id +
                ", technology: " + technology +
                ", description: " + description +
                ", enterpriseId: " + enterpriseId +
                ", state: " + state;
    }
}
