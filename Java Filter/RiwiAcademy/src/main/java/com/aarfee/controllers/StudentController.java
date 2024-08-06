package com.aarfee.controllers;

import com.aarfee.entities.StudentEntity;
import com.aarfee.models.StudentModel;
import com.aarfee.persistence.imodels.IStudentModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    IStudentModel studentModel = new StudentModel();

    public void create(StudentEntity req) {
        try {
            studentModel.create(req);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public StudentEntity readById(int id) {
        StudentEntity foundStudent = null;

        try {
            foundStudent = studentModel.readById(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundStudent;
    }

    public StudentEntity readByEmail(String email) {
        StudentEntity foundStudent = null;

        try {
            foundStudent = studentModel.readByEmail(email);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundStudent;
    }

    public List<StudentEntity> readAll() {
        List<StudentEntity> foundStudents = new ArrayList<>();

        try {
            foundStudents = studentModel.readAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundStudents;
    }

    public List<StudentEntity> readAllActive() {
        List<StudentEntity> foundStudents = new ArrayList<>();

        try {
            foundStudents = studentModel.readAllActive();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundStudents;
    }

    public void update(StudentEntity req, int id) {
        try {
            studentModel.update(req, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            studentModel.delete(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
