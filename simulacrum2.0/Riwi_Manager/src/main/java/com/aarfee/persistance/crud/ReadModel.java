package com.aarfee.persistance.crud;

public interface ReadModel<Id, Entity> {
    public Entity readById(Id id);
}
