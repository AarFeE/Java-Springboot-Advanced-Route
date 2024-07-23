public class Employee extends Person {
    private Integer id;
    private Double salary;

    public Employee (String name, Integer age,Integer id, Double salary) {
        super(name, age);

        this.id = id;
        this.salary = salary;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
