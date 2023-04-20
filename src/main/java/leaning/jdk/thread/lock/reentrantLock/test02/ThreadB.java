package leaning.jdk.thread.lock.reentrantLock.test02;

public class ThreadB extends Thread {
    MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}
