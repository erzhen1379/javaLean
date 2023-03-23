package leaning.rpc.service.Imp;


import leaning.rpc.Entity.Student;
import leaning.rpc.service.StudentService;

public class StudentServiceImp implements StudentService {
    @Override
    public Student getInfo() {
        Student stu = new Student();
        stu.setID("123456");
        stu.setAge(10);
        stu.setName("张三");
        return stu;
    }

    @Override
    public void print(Student stu) {
        System.out.println(stu.toString());
    }


}
