
import javax.swing.JOptionPane;

public class InteractiveMenu {

    public static void main(String[] args) {
        while (true) {
            String opt = JOptionPane.showInputDialog("""
                    Insert the number of your desired option:

                    1. Addition
                    2. Substraction
                    3. Multiplication
                    4. Division
                    5. Exit

                    """);


            if (!opt.equals("1") && !opt.equals("2") && !opt.equals("3") && !opt.equals("4") && !opt.equals("5")) {
                JOptionPane.showMessageDialog(null, "Not a Valid Option!");
                continue;
            }

            if (opt.equals("5")) {
                JOptionPane.showMessageDialog(null, "See you later!");
                break;
            }

            double numOne = Double.parseDouble(JOptionPane.showInputDialog("Insert the first number"));
            double numTwo = Double.parseDouble(JOptionPane.showInputDialog("Insert the second number"));

            if (opt.equals("1")) {
                JOptionPane.showMessageDialog(null, "The sum of "+numOne+" and "+numTwo+" is: "+(numOne+numTwo));
            }

            if (opt.equals("2")) {
                JOptionPane.showMessageDialog(null, "The substraction of "+numOne+" and "+numTwo+" is: "+(numOne-numTwo));
            }

            if (opt.equals("3")) {
                JOptionPane.showMessageDialog(null, "The multiplication of "+numOne+" and "+numTwo+" is: "+(numOne*numTwo));
            }

            if (opt.equals("4")) {
                JOptionPane.showMessageDialog(null, "The division of "+numOne+" and "+numTwo+" is: "+(numOne/numTwo));
            }
        }
    }
}
