package com.aarfee.menus;

import com.aarfee.controllers.CourseController;
import com.aarfee.entities.CourseEntity;
import com.aarfee.entities.StudentEntity;

import javax.swing.*;

public class CourseMenu {
    private static final CourseController courseController = new CourseController();

    public static void show() {
        while (true) {
            String courOpt = JOptionPane.showInputDialog("""
                    Insert the option you want to choose:
                    
                    1. Create Course
                    2. Read Course
                    3. Read All Courses
                    4. Update Course
                    5. Delete Course
                    6. Return
                    
                    """);

            if (courOpt == null || courOpt.equals("6")) {
                break;
            }

            else if (courOpt.equals("1")) {
                String name = JOptionPane.showInputDialog("Insert the name of the Course");
                String description = JOptionPane.showInputDialog("Insert the description of the Course");

                courseController.create(new CourseEntity(name, description));
            }

            else  if (courOpt.equals("2")) {
                Integer id = null;
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Course you want to find"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                CourseEntity foundCourse = courseController.readById(id);

                JOptionPane.showMessageDialog(null, foundCourse != null ? "Found Course:\n" + foundCourse.toString() :
                        "Course with ID '" + id + "' wasn't found");
            }

            else if (courOpt.equals("3")) {
                StringBuilder courses = new StringBuilder();

                for (CourseEntity course : courseController.readAll()) {
                    courses.append(course.toString()).append("\n");
                }

                JOptionPane.showMessageDialog(null, (!courses.isEmpty()) ? "List of All Courses:\n\n" + courses : "No Courses Were Found");
            }

            else if (courOpt.equals("4")) {
                Integer id = null;

                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Course you want to update"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                CourseEntity foundCourse = courseController.readById(id);

                if(foundCourse == null) {
                    JOptionPane.showMessageDialog(null, "Course with ID '" + id + "' wasn't found");
                    continue;
                }

                String newName = JOptionPane.showInputDialog("Insert the new name of the Course (or leave it empty if you don't want to change it)");
                String newDescription = JOptionPane.showInputDialog("Insert the new description of the Course (or leave it empty if you don't want to change it)");

                CourseEntity updateCourse = new CourseEntity(
                        newName.equals("") ? foundCourse.getName() : newName,
                        newDescription.equals("") ? foundCourse.getDescription() : newDescription
                );

                courseController.update(updateCourse, id);
            }

            else if (courOpt.equals("5")) {
                Integer id = null;

                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the Course you want to delete"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not a valid ID!");
                    continue;
                }

                CourseEntity foundCourse = courseController.readById(id);

                if (foundCourse == null) {
                    JOptionPane.showMessageDialog(null, "Course with ID '" + id + "' wasn't found");
                    continue;
                }

                courseController.delete(id);
            }

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}
