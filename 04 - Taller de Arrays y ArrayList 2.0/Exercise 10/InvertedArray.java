import java.util.Arrays;

import javax.swing.JOptionPane;

public class InvertedArray {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Insert an string to turn into an array separated by comas ','");
        String[] inputArr = input.split(",");
        String[] invertedArr = new String[inputArr.length];

        for (int j = 0 ,i = invertedArr.length-1; i >= 0; i--, j++) {
            invertedArr[i] = inputArr[j];
        }

        JOptionPane.showMessageDialog(null, "Inserted Array: "+Arrays.toString(inputArr)+"\n\nInvertedArray:"+Arrays.toString(invertedArr));
    }
}
