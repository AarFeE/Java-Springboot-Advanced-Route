import javax.swing.JOptionPane;

public class MultiplicationTable {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Insert the number you want to multiply"));
        String table = "MULTIPLICATION TABLE: "+num+"\n";

        for (int i = 0; i <= 10; i++) {
            table += "\n"+num+"x"+i+" = "+num*i;
        }

        JOptionPane.showMessageDialog(null, table, "Table of "+num, 1);
    }
}
