package leaning.jdk.thread.lock.reentrantLock.test10;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public Lock lock;
    public MyService(Boolean fair){
        lock = new ReentrantLock();
    }
    public void testMethod() {
        try {
            lock.lock();
            System.out.println(new Date()+ " : ThreadName  " + Thread.currentThread().getName() + "  方法开始");
            Thread.sleep(5);
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


}
