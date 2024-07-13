import java.util.Arrays;
import javax.swing.JOptionPane;

public class MatrixVerifier {
    public static void main(String[] args) {
        String values;
        String[] valuesArr;
        int[] castValues = new int[9];
        int[][] ogMatrix = new int[3][3];
        int[][] transMatrix = new int[3][3];
        try {
            values = JOptionPane.showInputDialog("Insert the 9 values of the matrix separated by coma ','");
            valuesArr = values.split(",");
            if (valuesArr.length != 9) {
                throw new Error();
            }
            for(int i = 0; i < valuesArr.length; i++) {
                castValues[i] = Integer.parseInt(valuesArr[i]);
            }
        } catch (Error | Exception e) {
            JOptionPane.showMessageDialog(null, "The inserted values are not valid");
        }

        int i = 0;
        
        for (int j = 0; j < ogMatrix.length; j++) {
            for (int h = 0; h < ogMatrix[j].length; h++) {
                ogMatrix[j][h] = castValues[i];
                transMatrix[h][j] = castValues[i];
                i++;
            }
        }

        JOptionPane.showMessageDialog(null, "The inserted matrix: \n\n" + Arrays.deepToString(ogMatrix) + "\n\nTranspositioned:\n\n" + Arrays.deepToString(transMatrix) + (Arrays.deepToString(ogMatrix).equals(Arrays.deepToString(transMatrix))?"\n\nThe Matrix is Symmetrical":"\n\nThe Matrix isn't Symmetrical"));

    }
}
