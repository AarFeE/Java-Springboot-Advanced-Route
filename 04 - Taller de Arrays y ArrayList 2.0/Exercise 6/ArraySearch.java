import javax.swing.JOptionPane;

public class ArraySearch {
    public static void main(String[] args) {
        String[] names = {"Andres", "Jorge", "Benito", "Tomas"};

        String toFind = JOptionPane.showInputDialog("Insert the name to find");

        for(int i = 0; i < names.length; i++) {
            if (names[i].equals(toFind)) {
                JOptionPane.showMessageDialog(null, "The inserted name was found in the position: "+i+" of the names array.");
                System.exit(0);
            }
        }
    }
}
