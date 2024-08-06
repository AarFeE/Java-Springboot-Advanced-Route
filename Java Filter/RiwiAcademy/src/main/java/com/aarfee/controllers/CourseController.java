package com.aarfee.controllers;

import com.aarfee.entities.CourseEntity;
import com.aarfee.models.CourseModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CourseController {
    CourseModel courseModel = new CourseModel();

    public void create(CourseEntity req) {
        try {
            courseModel.create(req);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public CourseEntity readById(int id) {
        CourseEntity foundCourse = null;

        try {
            foundCourse = courseModel.readById(id);
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundCourse;
    }

    public List<CourseEntity> readAll() {
        List<CourseEntity> foundCourses = new ArrayList<>();

        try {
            foundCourses = courseModel.readAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundCourses;
    }

    public void update(CourseEntity req, int id) {
        try {
            courseModel.update(req, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            courseModel.delete(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
