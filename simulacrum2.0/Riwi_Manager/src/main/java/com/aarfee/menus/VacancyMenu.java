package com.aarfee.menus;

import com.aarfee.controllers.VacancyController;
import com.aarfee.entities.VacancyEntity;

import javax.swing.*;

public class VacancyMenu {

    public static void show() {
        VacancyController vacancyController = new VacancyController();

        while (true) {
            String vacOpt = JOptionPane.showInputDialog("""
                            Insert the number of the option you want to choose:

                            1. Create Vacancy\

                            2. See All Vacancies\

                            3. Find Vacancy by ID\

                            4. Edit Vacancy by ID\

                            5. Delete Vacancy by ID\

                            6. Change State of Vacancy by ID\

                            7. Return
                            """);

            if (vacOpt == null || vacOpt.equals("7")) {
                break;
            }

            if (vacOpt.equals("1")) {
                String technology = JOptionPane.showInputDialog("Insert the technologies required for this vacancy: ");
                String description = JOptionPane.showInputDialog("Insert a description for this vacancy");
                int enterprise = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of this vacancy's enterprise"));
                int state = JOptionPane.showConfirmDialog(null, "Click Yes if the state is Active, or Click No otherwise");

                VacancyEntity newVacancy = new VacancyEntity(technology, description, enterprise, state == 1);

                vacancyController.create(newVacancy);
            }

            else if (vacOpt.equals("6")) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Insert the id of the vacancy you want to change the state of"));

                vacancyController.changeState(id);
            }
        }
    }
}
