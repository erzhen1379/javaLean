package leaning.jdk.object;

public class Student extends Person {
    public String school;
    
    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }
    
    public void study() {
        System.out.println(name + " is studying at " + school);
    }
}
