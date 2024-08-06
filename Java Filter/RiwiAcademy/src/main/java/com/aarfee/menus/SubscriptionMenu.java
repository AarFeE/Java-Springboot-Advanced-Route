package com.aarfee.menus;

import com.aarfee.controllers.SubscriptionController;
import com.aarfee.entities.CourseEntity;
import com.aarfee.entities.SubscriptionEntity;

import javax.swing.*;

public class SubscriptionMenu {
    private static final SubscriptionController subscriptionController = new SubscriptionController();

    public static void show() {
        while (true) {
            String subOpt = JOptionPane.showInputDialog("""
                    Insert the option you want to choose:
                    
                    1. Create Subscription
                    2. Read Subscription
                    3. Read All Subscriptions
                    4. Update Subscription
                    5. Delete Subscription
                    6. Return
                    
                    """);

            if (subOpt == null || subOpt.equals("6")) {
                break;
            }

            else if (subOpt.equals("1")) {
                Integer studentId = null;
                Integer courseId = null;
                try {
                    studentId = Integer.parseInt(JOptionPane.showInputDialog("Insert the Student ID"));
                    courseId = Integer.parseInt(JOptionPane.showInputDialog("Insert the Course ID"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                if (subscriptionController.checkSubscription(studentId, courseId) != null) {
                    JOptionPane.showMessageDialog(null, "This Subscription Already Exists!");
                    continue;
                }

                subscriptionController.create(new SubscriptionEntity(studentId, courseId));

            }

            else if (subOpt.equals("2")) {
                Integer id = null;
                String subscription = "";
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Subscription you want to find"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                subscription = subscriptionController.readStudentCourseById(id);

                JOptionPane.showMessageDialog(null, !subscription.equals("") ? "Found Subscription:\n" + subscription :
                        "No Subscription was found with the given ID");
            }

            else if (subOpt.equals("3")) {
                String subscriptions = subscriptionController.readStudentsCourses();

                JOptionPane.showMessageDialog(null, !subscriptions.isEmpty() ? "Found Subscriptions:\n" + subscriptions :
                        "No Subscriptions were found");
            }

            else if (subOpt.equals("4")) {
                Integer id = null;
                String subscription = "";
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Subscription you want to update"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                subscription = subscriptionController.readStudentCourseById(id);

                if (subscription == null) {
                    JOptionPane.showMessageDialog(null, "Subscription with ID '" + id + "' wasn't found");
                    continue;
                }

                Integer studentId = null;
                Integer courseId = null;
                try {
                    studentId = Integer.parseInt(JOptionPane.showInputDialog("Insert the new Student ID"));
                    courseId = Integer.parseInt(JOptionPane.showInputDialog("Insert the new Course ID"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                if (subscriptionController.checkSubscription(studentId, courseId) != null) {
                    JOptionPane.showMessageDialog(null, "This Subscription Already Exists!");
                    continue;
                }

                subscriptionController.update(new SubscriptionEntity(studentId, courseId), id);
            }

            else if (subOpt.equals("5")) {
                Integer id = null;
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Subscription you want to delete"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                int confirmDelete = JOptionPane.showConfirmDialog(null, "Click Yes if you want to delete this subscription." +
                        " (This will also delete all grades registers)");

                if (confirmDelete == 0) {
                    subscriptionController.delete(id);
                }
            }

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}
