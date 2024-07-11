import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PrimeNumbers {

    public static void main(String[] args) {
        int nums = Integer.parseInt(JOptionPane.showInputDialog("Insert the amount of primes you want to visualize"));
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        boolean flag;

        for (int i = 1, j = 3; i < nums; j += 2) {
            flag = true;
            for (int v = 3; v < j; v += 2) {
                if (j % v == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.add(j);
                i++;
            }
        }

        JOptionPane.showMessageDialog(null, primes, "THE PRIME NUMBERS", 1);
    }
}
