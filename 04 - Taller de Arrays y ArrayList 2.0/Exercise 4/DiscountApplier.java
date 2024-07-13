import javax.swing.JOptionPane;

public class DiscountApplier {
    public static void main(String[] args) {
        double purchase = Double.parseDouble(JOptionPane.showInputDialog("Insert the purchase total cost"));
        double finalCost = 0;

        if (200 <= purchase && purchase < 300) {
            finalCost = purchase - ((purchase * 10)/100);
        } else if (300 <= purchase && purchase < 500) {
            finalCost = purchase - ((purchase * 15)/100);
        } else if (500 <= purchase && purchase < 1000) {
            finalCost = purchase - ((purchase * 20)/100);
        } else if (1000 <= purchase) {
            finalCost = purchase - ((purchase * 25)/100);
        }

        JOptionPane.showMessageDialog(null, "Final Cost: "+finalCost);
    }
}
