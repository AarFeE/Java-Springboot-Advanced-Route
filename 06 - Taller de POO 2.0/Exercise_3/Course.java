
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int code;
    private String name;
    private final List<Student> students;

    public Course(int code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
