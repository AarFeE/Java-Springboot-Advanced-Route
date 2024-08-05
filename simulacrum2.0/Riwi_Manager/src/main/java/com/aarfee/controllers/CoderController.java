package com.aarfee.controllers;

import com.aarfee.entities.CoderEntity;
import com.aarfee.models.CoderModel;
import com.aarfee.persistance.imodel.ICoderModel;

import java.util.List;

public class CoderController {
    ICoderModel coderModel = new CoderModel();

    public void create (CoderEntity req) {
        try {
            this.coderModel.create(req);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public CoderEntity readById(Integer id) {
        try {
            return this.coderModel.readById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<CoderEntity> readAll() {
        try {
            return this.coderModel.readAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(CoderEntity req, int id) {
        try {
            this.coderModel.update(req, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            this.coderModel.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

