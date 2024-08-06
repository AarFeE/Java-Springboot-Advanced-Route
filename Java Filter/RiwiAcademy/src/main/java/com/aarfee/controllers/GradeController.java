package com.aarfee.controllers;

import com.aarfee.entities.GradeEntity;
import com.aarfee.models.GradeModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GradeController {
    GradeModel gradeModel = new GradeModel();

    public void create(GradeEntity req) {
        try {
            gradeModel.create(req);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public GradeEntity readById(int id) {
        GradeEntity foundGrade = null;

        try {
            foundGrade = gradeModel.readById(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundGrade;
    }

    public List<GradeEntity> readAll() {
        List<GradeEntity> foundGrades = new ArrayList<>();

        try {
            foundGrades = gradeModel.readAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundGrades;
    }

    public void update(GradeEntity req, int id) {
        try {
            gradeModel.update(req, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            gradeModel.delete(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
