package com.aarfee.controllers;

import com.aarfee.entities.VacancyEntity;
import com.aarfee.models.VacancyModel;
import com.aarfee.persistance.imodel.IVacancyModel;

import javax.swing.*;
import java.util.List;

public class VacancyController {
    IVacancyModel vacancyModel = new VacancyModel();

    public void create(VacancyEntity req) {
        try {
            this.vacancyModel.create(req);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(e.getMessage()));
        }
    }

    public VacancyEntity readById(int id) {
        return this.vacancyModel.readById(id);
    }

    public List<VacancyEntity> readAll() {
        return this.vacancyModel.readAll();
    }

    public void update(VacancyEntity req, int id) {
        this.vacancyModel.update(req, id);
    }

    public void delete(int id) {
        this.vacancyModel.delete(id);
    }

    public void changeState(int id) {
        try {
            this.vacancyModel.changeState(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(e.getMessage()));
        }
    }
}
