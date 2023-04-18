package leaning.jdk.thread.threadstatus;

public class Mythread03 extends Thread{
    @Override
    public void run() {
        MyService myService = new MyService();
        myService.serviceMethod();
    }
}
