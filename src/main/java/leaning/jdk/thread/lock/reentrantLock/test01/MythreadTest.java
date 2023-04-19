package leaning.jdk.thread.lock.reentrantLock.test01;

public class MythreadTest {
    public static void main(String[] args) {
        MyService01 myService = new MyService01();
        MyThread01 myThread01 = new MyThread01(myService);
        MyThread01 myThread02 = new MyThread01(myService);
        MyThread01 myThread03 = new MyThread01(myService);
        MyThread01 myThread04 = new MyThread01(myService);
        myThread01.start();
        myThread03.start();
        myThread02.start();
        myThread04.start();


   /*     for (int i = 0; i < 100; i++) {

            new MyThread01(myService).start();
        }*/
    }
}
