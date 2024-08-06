package com.aarfee.persistence.crud;

public interface UpdateModel<Entity, ID> {
    public void update(Entity req, ID id);
}
