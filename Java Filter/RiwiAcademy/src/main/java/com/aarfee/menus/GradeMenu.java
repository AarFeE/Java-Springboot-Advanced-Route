package com.aarfee.menus;

import com.aarfee.controllers.GradeController;
import com.aarfee.entities.GradeEntity;

import javax.swing.*;

public class GradeMenu {
    private static final GradeController gradeController = new GradeController();

    public static void show() {

        while (true) {
            String gradOpt = JOptionPane.showInputDialog("""
                    Insert the option you want to choose:
                    
                    1. Create Grade
                    2. Read Grade
                    3. Read All Grades
                    4. Update Grade
                    5. Delete Grade
                    6. Return
                    
                    """);

            if (gradOpt == null || gradOpt.equals("6")) {
                break;
            }

            else if (gradOpt.equals("1")) {
                Integer subscriptionId = null;
                Double value = null;
                try {
                    subscriptionId = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of this Grade's Subscription"));
                    value = Double.parseDouble(JOptionPane.showInputDialog("Insert the Value of the Grade"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid Inserted Value!");
                    continue;
                }

                gradeController.create(new GradeEntity(value, subscriptionId));
            }

            else if (gradOpt.equals("2")) {
                Integer id = null;
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Grade you want to find"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                GradeEntity foundGrade = gradeController.readById(id);

                JOptionPane.showMessageDialog(null, foundGrade != null ? "Found Grade:\n" + foundGrade.toString() :
                        "Grade with ID '" + id + "' wasn't found");
            }

            else if (gradOpt.equals("3")) {
                StringBuilder grades = new StringBuilder();

                for (GradeEntity grade : gradeController.readAll()) {
                    grades.append(grade.toString()).append("\n");
                }

                JOptionPane.showMessageDialog(null, (!grades.isEmpty()) ? "List of All Grades:\n\n" + grades : "No Grades Were Found");
            }

            else if (gradOpt.equals("4")) {
                Integer id = null;

                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Grade you want to update"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                GradeEntity foundGrade = gradeController.readById(id);

                if (foundGrade == null) {
                    JOptionPane.showMessageDialog(null, "Grade with ID '" + id + "' wasn't found");
                    continue;
                }

                Integer newSubscriptionId = null;
                Double newValue = null;
                try {
                    newSubscriptionId = Integer.parseInt(JOptionPane.showInputDialog("Insert the new ID of this Grade's Subscription"));
                    newValue = Double.parseDouble(JOptionPane.showInputDialog("Insert the new Value of the Grade"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid Inserted Value!");
                    continue;
                }

                GradeEntity updateGrade = new GradeEntity(
                        newValue,
                        newSubscriptionId
                );

                gradeController.update(updateGrade, id);
            }

            else if (gradOpt.equals("5")) {
                Integer id = null;

                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Grade you want to delete"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                GradeEntity foundGrade = gradeController.readById(id);

                if (foundGrade == null) {
                    JOptionPane.showMessageDialog(null, "Grade with ID '" + id + "' wasn't found");
                    continue;
                }

                gradeController.delete(id);
            }

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}
