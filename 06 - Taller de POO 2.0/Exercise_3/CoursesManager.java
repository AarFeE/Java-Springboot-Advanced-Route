
import java.util.ArrayList;
import java.util.List;

public class CoursesManager {
    private final List<Course> courses;

    public CoursesManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Course getCourseByName(String name) {
        for (Course course : this.courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }

    public void addStudentToCourse (String name, Student student) {
        Course course = getCourseByName(name);
        if (course != null) {
            course.addStudent(student);
        }
    }

    public List<Student> getStudentsByCourse (String name) {
        Course course = getCourseByName(name);
        if (course != null) {
            return course.getStudents();
        }
        return null;
    }
}
