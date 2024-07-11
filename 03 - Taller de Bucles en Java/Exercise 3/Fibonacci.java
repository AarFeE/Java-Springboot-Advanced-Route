import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class Fibonacci {
    public static void main(String[] args) {
        int nums = Integer.parseInt(JOptionPane.showInputDialog("Insert the amount of numbers from the Fibonacci sequence you want to visualize"));
        List<Integer> fibonacci = new ArrayList<>(Arrays.asList(0, 1));

        while (fibonacci.size() < nums) {
            fibonacci.add(fibonacci.get(fibonacci.size()-1)+fibonacci.get(fibonacci.size()-2));
        }
        
        JOptionPane.showMessageDialog(null, fibonacci);
    }
}
