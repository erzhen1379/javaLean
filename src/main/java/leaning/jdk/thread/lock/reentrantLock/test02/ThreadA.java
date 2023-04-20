package leaning.jdk.thread.lock.reentrantLock.test02;

public class ThreadA extends Thread {
    MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}
