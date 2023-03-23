package leaning.rpc.service;


import leaning.rpc.Entity.Student;

public interface StudentService {
    public Student getInfo();
    public void print(Student stu);
}
