import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class WordFinder {
    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog("Insert a text").toLowerCase();
        String toFind = JOptionPane.showInputDialog("Insert the word to find").toLowerCase();
        String[] textArr = text.split(" ");
        List<Integer> foundIndex = new ArrayList<>();

        for (int i = 0; i < textArr.length; i++) {
            textArr[i] = textArr[i].replaceAll("[^a-zA-Z]", "");
        }

        for (int i = 0; i < textArr.length; i++) {
            if (textArr[i].equals(toFind)){
                foundIndex.add(i);
            }
        }

        JOptionPane.showMessageDialog(null, "The word "+toFind+" was found in the positions: "+foundIndex);
    }
}
