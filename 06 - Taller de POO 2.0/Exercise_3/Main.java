public class Main {
    public static void main(String[] args) {
        Student a = new Student(0, "AarFeE", "aarfee@email.com");
        Student b = new Student(1, "Toplu", "toplu@email.com");
        Student c = new Student(2, "Claper", "claper@email.com");
        Student d = new Student(3, "Blown", "blown@email.com");

        Course math = new Course(0, "Math");
        Course physics = new Course(1, "Physics");

        CoursesManager coursesManager = new CoursesManager();
        coursesManager.addCourse(math);
        coursesManager.addCourse(physics);

        coursesManager.addStudentToCourse("Math", a);
        coursesManager.addStudentToCourse("Math", b);
        coursesManager.addStudentToCourse("Physics", c);
        coursesManager.addStudentToCourse("Physics", d);
        
        System.out.println(coursesManager.getStudentsByCourse("Math"));
    }
}