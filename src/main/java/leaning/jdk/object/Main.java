package leaning.jdk.object;

public class Main {
    public static void main(String[] args) {
        // 创建一个Person对象
        Person person = new Person("John", 25);
        
        // 创建一个Student对象
        Student student = new Student("Tom", 18, "ABC School");
        
        // 访问父类属性和方法
        System.out.println(person.name);  // 输出：John
        System.out.println(person.age);  // 输出：25
        person.eat();  // 输出：John is eating.
        
        // 访问子类属性和方法
        System.out.println(student.name);  // 输出：Tom
        System.out.println(student.age);  // 输出：18
        System.out.println(student.school);  // 输出：ABC School
        student.eat();  // 输出：Tom is eating.
        student.study();  // 输出：Tom is studying at ABC School
        student.eat();
    }
}
