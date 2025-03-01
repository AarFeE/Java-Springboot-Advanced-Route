import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StoreBilling {
    public static void main (String[] args) {
        List<NumberStringPair> products = new ArrayList<>();

        products.add(new NumberStringPair("Sugar 1kg", 14900));
        products.add(new NumberStringPair("Coffee 100gr", 7490));
        products.add(new NumberStringPair("Canned beans", 6900));
        products.add(new NumberStringPair("Ground beef 1kg", 22900));

        String msg = "";

        for (int i = 0; i < products.size(); i++) {
            msg += "\n"+(i+1)+": "+products.get(i).text()+" ------------- "+products.get(i).number();
        }

        String purchase;
        String[] purchaseArray;
        Integer[] castArray;

        while (true) {
            purchase = JOptionPane.showInputDialog("Insert the number of the products you want to add, separated by ','\n"+msg);
            try {
                purchaseArray = purchase.split(",");
                castArray = new Integer[purchaseArray.length];
                for (int i = 0; i < purchaseArray.length; i++) {
                    System.out.println(Integer.valueOf(purchaseArray[i]) -1);
                    castArray[i] = (Integer.parseInt(purchaseArray[i]) - 1);
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Inserted values are not valid!");
            }
        }

        int quantity, total = 0;
        msg = "\n";

        for (Integer i : castArray) {
            try {
                if( 0 > i || i > 3 ) {
                    throw new Error();
                }
                while (true) {
                    try {
                        quantity = Integer.parseInt(JOptionPane.showInputDialog("Insert the quantity of "+products.get(i).text()+" you want to buy"));
                        msg += products.get(i).text()+" * " + quantity + " ---------- " + (products.get(i).number()*quantity) + "\n";
                        total += products.get(i).number()*quantity;
                        break;
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Inserted values are not valid!");
                    }
                }
                
            } catch (Error e) {
                JOptionPane.showMessageDialog(null, "Inserted values are not valid!");
                System.exit(total);
            }
        }

        JOptionPane.showMessageDialog(null, "Your Purchases:\n"+msg+"\nTotal: "+total);

    }
}