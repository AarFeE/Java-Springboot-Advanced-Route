package com.aarfee;

import com.aarfee.controllers.CoderController;
import com.aarfee.controllers.EnterpriseController;
import com.aarfee.controllers.VacancyController;
import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.entities.VacancyEntity;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EnterpriseController enterpriseController = new EnterpriseController();
        CoderController coderController = new CoderController();
        VacancyController vacancyController = new VacancyController();

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
                while (true) {
                    String entOpt = JOptionPane.showInputDialog("""
                            Insert the number of the option you want to choose:

                            1. Create Enterprise\

                            2. See All Enterprises\

                            3. Find Enterprise by ID\

                            4. Edit Enterprise by ID\

                            5. Delete Enterprise by ID\

                            6. Return
                            """);

                    if (entOpt.equals("6")) {
                        break;
                    }
                }
            }

            else if (mainOpt.equals("2")) {
                JOptionPane.showMessageDialog(null, "Coders Manager");
            }

            else if (mainOpt.equals("3")) {
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

            else {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
            }
        }
    }
}