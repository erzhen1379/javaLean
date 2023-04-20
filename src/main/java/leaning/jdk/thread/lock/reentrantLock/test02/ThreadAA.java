package leaning.jdk.thread.lock.reentrantLock.test02;

public class ThreadAA extends Thread {
    MyService myService;

    public ThreadAA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}
