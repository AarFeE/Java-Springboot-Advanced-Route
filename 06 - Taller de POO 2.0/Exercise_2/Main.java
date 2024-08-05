
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee a = new Employee("A", 22, 1, 26900.0);
        Employee b = new Employee("B", 23, 2, 27000.0);
        TemporalEmployee c = new TemporalEmployee("C TEMP", 24, 3, 38000.0, new Date());
        PermanentEmployee d = new PermanentEmployee("D PERM", 27, 4, 29900.0, "No End-Date");

        EmployeesManager manager = new EmployeesManager();
        manager.addEmployee(a);
        manager.addEmployee(b);
        manager.addEmployee(c);
        manager.addEmployee(d);

        System.out.println(manager.getEmployees());
    }
}