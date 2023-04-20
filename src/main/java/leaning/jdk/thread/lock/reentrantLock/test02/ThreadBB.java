package leaning.jdk.thread.lock.reentrantLock.test02;

public class ThreadBB extends Thread {
    MyService myService;

    public ThreadBB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}
