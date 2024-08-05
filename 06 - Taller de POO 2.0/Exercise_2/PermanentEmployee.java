public class PermanentEmployee extends Employee {
    private String contractType;

    public PermanentEmployee (String name, Integer age,Integer id, Double salary, String contractType) {
        super(name, age,id, salary);

        this.contractType = contractType;
    }

    public String getContractType() {
        return this.contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}
