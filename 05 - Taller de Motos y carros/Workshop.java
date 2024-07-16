
import javax.swing.JOptionPane;

public class Workshop {

    public static void main(String[] args) {
        int activeWorks, works, onEmployees, maxEmployees = Integer.parseInt(JOptionPane.showInputDialog("How many employees do you have?"));
        String schedule, findBrand, findModel, option, stateOption, state;
        Boolean flag = false;
        String[] employeesArr = new String[maxEmployees];
        Integer[][] vehiclesArr = new Integer[maxEmployees][2];
        String[][][] jobsArr = new String[maxEmployees][2][4];

        while (true) {
            onEmployees = Integer.parseInt(JOptionPane.showInputDialog("How many employees are active working?"));

            if (onEmployees <= maxEmployees) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number less than or equal to " + maxEmployees);
            }
        }

        while (true) {
            activeWorks = Integer.parseInt(JOptionPane.showInputDialog("How many active works do you have?"));

            if (activeWorks <= (onEmployees * 2)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number less than or equal to " + (onEmployees * 2));
            }

        }

        for (int i = 0; i < onEmployees; i++) {
            employeesArr[i] = JOptionPane.showInputDialog("What's the employee number: " + i + " name?");
        }

        works = activeWorks;
        for (int i = 0; i < onEmployees; i++) {
            for (int j = 0; j < 2; j++) {
                if (works == 0) {
                    break;
                }
                while (true) {
                    vehiclesArr[i][j] = Integer.valueOf(JOptionPane.showInputDialog("Employee " + employeesArr[i] + " assigned vehicle: " + j + "\n"
                            + "\nType 0 if the vehicle is a bike or 1 if the vehicle is a car. "));

                    if (vehiclesArr[i][j] == 0 || vehiclesArr[i][j] == 1) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter 0 or 1");
                    }
                }
                works--;
            }

            if (works == 0) {
                break;
            }
        }

        works = activeWorks;
        schedule = "\nTipo         Marca         Modelo         Año         Estado\n";
        for (int i = 0; i < onEmployees; i++) {
            for (int j = 0; j < 2; j++) {
                if (works == 0) {
                    break;
                }
                jobsArr[i][j][0] = JOptionPane.showInputDialog("Insert the vehicle's " + j + " of the employee " + employeesArr[i] + " brand: ");
                jobsArr[i][j][1] = JOptionPane.showInputDialog("Insert the vehicle's " + j + " of the employee " + employeesArr[i] + " model: ");
                jobsArr[i][j][2] = JOptionPane.showInputDialog("Insert the vehicle's " + j + " of the employee " + employeesArr[i] + " year: ");

                while (true) {
                    jobsArr[i][j][3] = JOptionPane.showInputDialog("Insert the vehicle's " + j + " of the employee " + employeesArr[i] + " state (pendiente, reparando, terminado): ");

                    if (jobsArr[i][j][3].equals("pendiente") || jobsArr[i][j][3].equals("reparando") || jobsArr[i][j][3].equals("terminado")) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid state");
                    }
                }

                schedule += "\n" + (vehiclesArr[i][j] == 0 ? "Bike" : "Car") + "         " + jobsArr[i][j][0] + "         " + jobsArr[i][j][1] + "         " + jobsArr[i][j][2] + "         " + jobsArr[i][j][3];
                works--;
            }

            if (works == 0) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Schedule: \n" + schedule);

        while (true) {
            option = JOptionPane.showInputDialog("""
                                                 Insert the number of the option:

                                                 1. Show the schedule
                                                 2. Find vehicle by brand and model
                                                 3. Exit
                                                 """);

            if (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid option");
            } else if (option.equals("3")) {
                JOptionPane.showMessageDialog(null, "Thanks for using our Workshop administrator");
                break;
            } else if (option.equals("1")) {
                works = activeWorks;
                schedule = "\nTipo         Marca         Modelo         Año         Estado\n";
                for (int i = 0; i < onEmployees; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (works == 0) {
                            break;
                        }

                        schedule += "\n" + (vehiclesArr[i][j] == 0 ? "Bike" : "Car") + "         " + jobsArr[i][j][0] + "         " + jobsArr[i][j][1] + "         " + jobsArr[i][j][2] + "         " + jobsArr[i][j][3];

                        works--;
                    }

                    if (works == 0) {
                        break;
                    }
                }

                JOptionPane.showMessageDialog(null, "Schedule: \n" + schedule);
            } else if (option.equals("2")) {
                findBrand = JOptionPane.showInputDialog("Insert the brand: ");
                findModel = JOptionPane.showInputDialog("Insert the model: ");

                works = activeWorks;
                for (int i = 0; i < onEmployees; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (works == 0) {
                            break;
                        }
                        if (jobsArr[i][j][0].equals(findBrand) && jobsArr[i][j][1].equals(findModel)) {
                            while (true) {
                                stateOption = JOptionPane.showInputDialog("Employee " + employeesArr[i] + " assigned vehicle: " + j + "\n\nBrand: " + jobsArr[i][j][0] + "\n" + "Model: " + jobsArr[i][j][1] + "\n" + "Year: " + jobsArr[i][j][2] + "\n" + "State: " + jobsArr[i][j][3] + "\n\nInsert 1 if you want to change the state of the vehicle or 0 to comeback to the menu");

                                if (stateOption.equals("1") || stateOption.equals("0")) {
                                    break;
                                }

                                JOptionPane.showMessageDialog(null, "Please enter 1 or 0");
                            }

                            if (stateOption.equals("1")) {
                                while (true) {
                                    state = JOptionPane.showInputDialog("Insert the new state (pendiente, reparando, terminado) Current State: " + jobsArr[i][j][3]);

                                    if (state.equals("pendiente") || state.equals("reparando") || state.equals("terminado")) {
                                        break;
                                    }

                                    JOptionPane.showMessageDialog(null, "Please enter a valid state");
                                }

                                jobsArr[i][j][3] = state;
                                JOptionPane.showMessageDialog(null, "State changed successfully");
                                flag = true;
                                break;
                            }
                        }

                        works--;
                    }

                    if (flag) {
                        break;
                    }

                    if (works == 0) {
                        JOptionPane.showMessageDialog(null, "Vehicle not found");
                        break;
                    }
                }
            }
        }
    }
}
