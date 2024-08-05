package com.aarfee;

import com.aarfee.controllers.CoderController;
import com.aarfee.controllers.EnterpriseController;
import com.aarfee.controllers.VacancyController;
import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.entities.VacancyEntity;
import com.aarfee.menus.EnterpriseMenu;
import com.aarfee.menus.VacancyMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CoderController coderController = new CoderController();

        while (true) {
            String mainOpt = JOptionPane.showInputDialog("""
                    Insert the number of the option you want to choose:

                    1. Enterprises Manager\

                    2. Coders Manager\

                    3. Vacancies Manager\

                    4. Exit
                    """);

            if (mainOpt == null || mainOpt.equals("4")) {
                JOptionPane.showMessageDialog(null, "Thanks for Using our Manager!");
                break;
            }

            else if (mainOpt.equals("1")) {
                EnterpriseMenu.show();
            }

            else if (mainOpt.equals("2")) {
                JOptionPane.showMessageDialog(null, "Coders Manager");
            }

            else if (mainOpt.equals("3")) {
                VacancyMenu.show();
            }

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}