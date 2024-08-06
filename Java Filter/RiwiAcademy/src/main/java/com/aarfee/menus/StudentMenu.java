package com.aarfee.menus;

import com.aarfee.controllers.StudentController;
import com.aarfee.entities.StudentEntity;

import javax.swing.*;
import java.util.Objects;

public class StudentMenu {
    private static final StudentController studentController = new StudentController();

    public static <List> void show() {
        while (true) {
            String studOpt = JOptionPane.showInputDialog("""
                    Insert the option you want to choose:
                    
                    1. Create Student
                    2. Read Student
                    3. Read All Students
                    4. Read All Active Students
                    5. Update Student
                    6. Delete Student
                    7. Return
                    
                    """);

            if (studOpt == null || studOpt.equals("7")) {
                break;
            }

            else if (studOpt.equals("1")) {
                String name = JOptionPane.showInputDialog("Insert the name of the Student");
                String email = JOptionPane.showInputDialog("Insert the email of the Student");
                boolean state = JOptionPane.showConfirmDialog(null, "Click Yes if the state of the Student is active") == 0;

                studentController.create(new StudentEntity(name, email, state));
            }

            else if (studOpt.equals("2")) {
                String email = "";
                Integer id = null;
                StudentEntity foundStudent = null;

                String findOpt = JOptionPane.showInputDialog("""
                        Insert the read Option:
                        
                        1. Read by Id
                        2. Read By Email
                        
                        """);

                if (findOpt.equals("1")) {

                    try {
                        id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Student you want to find"));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Not a valid ID!");
                        continue;
                    }

                    foundStudent = studentController.readById(id);
                }

                else if (findOpt.equals("2")) {

                    email = JOptionPane.showInputDialog("Insert the email of the Student you want to find");
                    foundStudent = studentController.readByEmail(email);
                }

                JOptionPane.showMessageDialog(null, foundStudent != null ? "Found Student:\n" + foundStudent.toString() : findOpt.equals("1") ?
                        "Student with ID '" + id + "' wasn't found" : "Student with email '" + email + "' wasn't found");
            }

            else if (studOpt.equals("3")) {
                StringBuilder students = new StringBuilder();

                for (StudentEntity student : studentController.readAll()) {
                    students.append(student.toString()).append("\n");
                }

                JOptionPane.showMessageDialog(null, (!students.isEmpty()) ? "List of All Students:\n\n" + students : "No Students Were Found");
            }

            else if (studOpt.equals("4")) {
                StringBuilder students = new StringBuilder();

                for (StudentEntity student : studentController.readAllActive()) {
                    students.append(student.toString()).append("\n");
                }

                JOptionPane.showMessageDialog(null, (!students.isEmpty()) ? "List of All Active Students:\n\n" + students : "No Students Were Found");
            }

            else if (studOpt.equals("5")) {
                Integer id = null;

                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Student you want to update"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                StudentEntity foundStudent = studentController.readById(id);

                if(foundStudent == null) {
                    JOptionPane.showMessageDialog(null, "Student with ID '" + id + "' wasn't found");
                    continue;
                }

                String newName = JOptionPane.showInputDialog("Insert the new name of the Student (or leave it empty if you don't want to change it)");
                String newEmail = JOptionPane.showInputDialog("Insert the new email of the Student (or leave it empty if you don't want to change it)");
                int intNewState = JOptionPane.showConfirmDialog(null, "Click Yes if you want to change this Students' state to Active, No if " +
                        "you want to set it as Inactive, or Cancel to leave this field unmodified");

                Boolean newState = intNewState == 0 ? Boolean.TRUE : intNewState == 1 ? false : null;

                StudentEntity updateStudent = new StudentEntity(
                        newName.equals("") ? foundStudent.getName() : newName,
                        newEmail.equals("") ? foundStudent.getEmail() : newEmail,
                        newState == null ? foundStudent.getState() : newState
                );

                studentController.update(updateStudent, id);
            }

            else if (studOpt.equals("6")) {
                Integer id = null;

                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Student you want to delete"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                StudentEntity foundStudent = studentController.readById(id);

                if (foundStudent == null) {
                    JOptionPane.showMessageDialog(null, "Student with ID '" + id + "' wasn't found");
                    continue;
                }

                studentController.delete(id);
            }

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}
