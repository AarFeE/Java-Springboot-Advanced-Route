
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class CourseGrades {
    public static void main(String[] args) {
        Double[] grades = new Double[8];
        double grade;
        String msg = "";
        int flag, cont = 0, accum = 0;

        for (int i = 0; i < grades.length; i++) {
            flag = JOptionPane.showConfirmDialog(null, "Do you want to add another grade?");
            if (flag == 1) {
                break;
            } else if (flag == 2) {
                System.exit(0);
            }
            while (true) {
                try {
                    grade = Double.parseDouble(JOptionPane.showInputDialog("Insert the "+(i)+" grade"));
                    if (0 > grade || grade > 100) {
                        throw new Error();
                    }
                    msg += grade+", ";
                    accum += grade;
                    cont ++;
                    grades[i] = grade;
                    break;
                } catch (HeadlessException | NumberFormatException | Error e) {
                    JOptionPane.showMessageDialog(null, "Not a Valid Option!");
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Inserted Grades: " + msg);
        double rawNeeded = 608-accum;
        double needed = rawNeeded/(8-cont);
        JOptionPane.showMessageDialog(null, (needed < 100)?("The needed grade for the next exams to pass this course is: "+needed):"There's no chance, u are danzo my boi", "Needed Grade", 1);
    }
}
