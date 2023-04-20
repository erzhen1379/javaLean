package leaning.jdk.thread.lock.reentrantLock.test10;

public class MyThread extends Thread {
    MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
