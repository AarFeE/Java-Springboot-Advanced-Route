
import java.util.ArrayList;
import java.util.List;

public class EmployeesManager {
    private final List<Employee> employees;

    public EmployeesManager () {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}
