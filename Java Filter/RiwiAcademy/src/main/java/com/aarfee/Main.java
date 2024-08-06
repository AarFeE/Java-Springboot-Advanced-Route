package com.aarfee;

import com.aarfee.menus.CourseMenu;
import com.aarfee.menus.GradeMenu;
import com.aarfee.menus.StudentMenu;
import com.aarfee.menus.SubscriptionMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String mainOpt = JOptionPane.showInputDialog("""
                    Insert the number of the Option you want to choose:
                    
                    1. Students Manager
                    2. Courses Manager
                    3. Subscriptions Manager
                    4. Grades Manager
                    5. Exit
                    
                    """);

            if (mainOpt == null || mainOpt.equals("5")) {
                JOptionPane.showMessageDialog(null, "Thanks for using our Riwi Academy Manager!");
                break;
            }

            else if (mainOpt.equals("1")) {
                StudentMenu.show();
            }

            else if (mainOpt.equals("2")) {
                CourseMenu.show();
            }

            else if (mainOpt.equals("3")) {
                SubscriptionMenu.show();
            }

            else if (mainOpt.equals("4")) {
                GradeMenu.show();
            }

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}