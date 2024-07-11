
import javax.swing.JOptionPane;

public class Factorial {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Insert the number you wish to get the factorial from"));
        int accum = 1;

        for (int i = num; i > 0; i --){
            accum *= i;
        }

        JOptionPane.showMessageDialog(null, num+"! "+accum);
    }
}
