import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class ArrayDuplicates {
    public static void main(String[] args) {
        TreeMap<String, Integer> duplicates = new TreeMap<>();
        List<Map.Entry<String, Integer>> result = new ArrayList<>();
        String[] inputArr;

        String input = JOptionPane.showInputDialog("Insert a string to turn into an array separated by comas ','");
        inputArr = input.split(",");

        for (String value : inputArr) {
            if (!duplicates.containsKey(value)) {
                duplicates.put(value, 1);
            } else {
                duplicates.put(value, duplicates.get(value)+1);
            }
        }

        for (Map.Entry<String, Integer> i: duplicates.entrySet()) {
            result.add(i);
        }

        result.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        JOptionPane.showMessageDialog(null, "Ordered Duplicates: "+result);

    }
}
