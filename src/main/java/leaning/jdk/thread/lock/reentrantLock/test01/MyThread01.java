package leaning.jdk.thread.lock.reentrantLock.test01;

public class MyThread01 extends Thread {
    MyService01 myService01;

    public MyThread01(MyService01 myService01) {
        super();
        this.myService01 = myService01;
    }

    @Override
    public void run() {
        myService01.testMethod();
    }
}
