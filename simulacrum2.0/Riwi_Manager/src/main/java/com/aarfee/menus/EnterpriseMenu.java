package com.aarfee.menus;

import com.aarfee.controllers.EnterpriseController;

import javax.swing.*;

public class EnterpriseMenu {
    public static void show() {
        EnterpriseController enterpriseController = new EnterpriseController();

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
}
