public class Person {   
    private String name;
    private Integer age;

    public Person (String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
