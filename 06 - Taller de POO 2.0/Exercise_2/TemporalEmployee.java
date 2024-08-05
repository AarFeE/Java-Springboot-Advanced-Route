
import java.util.Date;

public class TemporalEmployee extends Employee {
    private Date contractEnd;

    public TemporalEmployee (String name, Integer age,Integer id, Double salary, Date contractEnd) {
        super(name, age,id, salary);

        this.contractEnd = contractEnd;
    }

    public Date getContractEnd() {
        return this.contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }
}
