import java.util.Arrays;

import javax.swing.JOptionPane;

public class MatrixTransposition {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int [][] transMat = new int [3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transMat[j][i] = matrix[i][j];
            }
        }

        JOptionPane.showMessageDialog(null, Arrays.deepToString(transMat));
    }
}
