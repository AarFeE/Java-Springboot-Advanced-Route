package com.aarfee.entities;

public class StudentEntity {
    private int id;
    private String name;
    private String email;
    private boolean state;

    public StudentEntity() {};

    public StudentEntity(int id, String name, String email, boolean state) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.state = state;
    }

    public StudentEntity(String name, String email, boolean state) {
        this.name = name;
        this.email = email;
        this.state = state;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student w/ ID: " + this.id +
                ", Name: " + this.name +
                ", Email: " + this.email +
                ", State: " + this.state;
    }
}
