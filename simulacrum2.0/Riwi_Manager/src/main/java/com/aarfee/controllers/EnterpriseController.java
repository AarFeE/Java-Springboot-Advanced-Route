package com.aarfee.controllers;

import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.models.EnterpriseModel;
import com.aarfee.persistance.imodel.IEnterpriseModel;

import java.util.List;

public class EnterpriseController {
    IEnterpriseModel enterpriseModel = new EnterpriseModel();

    public void create (EnterpriseEntity req) {
        try {
            this.enterpriseModel.create(req);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public EnterpriseEntity readById (int id) {
        return this.enterpriseModel.readById(id);
    }

    public List<EnterpriseEntity> readAll () {
        return this.enterpriseModel.readAll();
    }

    public void update (EnterpriseEntity req, int id) {
        this.enterpriseModel.update(req, id);
    }

    public void delete (int id) {
        enterpriseModel.delete(id);
    }
}
