package com.aarfee.controllers;

import com.aarfee.entities.SubscriptionEntity;
import com.aarfee.models.SubscriptionModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionController {
    SubscriptionModel subscriptionModel = new SubscriptionModel();

    public void create(SubscriptionEntity req) {
         try {
             subscriptionModel.create(req);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }

    public SubscriptionEntity readById (int id) {
        SubscriptionEntity foundSubcription = null;

        try {
            foundSubcription = subscriptionModel.readById(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundSubcription;
    }

    public SubscriptionEntity checkSubscription(int studentId, int courseId) {
        SubscriptionEntity foundSubcription = null;

        try {
            foundSubcription = subscriptionModel.checkSubscription(studentId, courseId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return foundSubcription;
    }

    public String readStudentCourseById(int id) {
        String subscription = "";

        try {
            subscription = subscriptionModel.readStudentCourseById(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return subscription;
    }

    public String readStudentsCourses() {
        String subscriptions = "";

        try {
            subscriptions = subscriptionModel.readStudentsCourses();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return subscriptions;
    }

    public List<SubscriptionEntity> readAll() {
        List<SubscriptionEntity> foundSubscriptions = new ArrayList<>();

        try {
            foundSubscriptions = subscriptionModel.readAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return  foundSubscriptions;
    }

    public void update(SubscriptionEntity req, int id) {
        try {
            subscriptionModel.update(req, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            subscriptionModel.delete(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
