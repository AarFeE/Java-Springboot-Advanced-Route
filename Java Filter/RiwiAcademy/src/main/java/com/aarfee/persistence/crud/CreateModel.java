package com.aarfee.persistence.crud;

public interface CreateModel<Entity> {
    public void create(Entity req);
}
