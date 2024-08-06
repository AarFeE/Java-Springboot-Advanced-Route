package com.aarfee.persistence.crud;

public interface ReadModel<Entity, ID> {
    public Entity readById(ID id);
}
