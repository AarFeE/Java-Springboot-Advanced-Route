
import javax.swing.JOptionPane;

public class Diamond {
    public static void main (String [] args) {
        int lines = Integer.parseInt(JOptionPane.showInputDialog("Insert the number of lines for the diamond divided by 2"));
        String diamond = "";

        for (int i = 1, l = 1, j = lines; i <= lines; i++, l+=2, j--){
            diamond += " ".repeat(j)+"*".repeat(l)+"\n";
        }
        
        for (int i = lines, l = (lines*2)-1, j = 1; i>0; i--, l-=2, j++){
            diamond += " ".repeat(j)+"*".repeat(l)+"\n";
        }

        JOptionPane.showMessageDialog(null, diamond);
        System.out.println(diamond);
    }
}