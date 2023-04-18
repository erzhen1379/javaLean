package leaning.jdk.thread.threadstatus;

public class Mythread04 extends Thread{
    @Override
    public void run() {
        MyService myService = new MyService();
        myService.serviceMethod();
    }
}
