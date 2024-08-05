package com.aarfee.persistance.crud;

public interface UpdateModel<Id, Entity> {
    public void update(Entity req, Id id);
}
