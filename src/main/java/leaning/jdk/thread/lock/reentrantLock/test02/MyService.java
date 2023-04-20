package leaning.jdk.thread.lock.reentrantLock.test02;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println(new Date()+ " : ThreadName  " + Thread.currentThread().getName() + "  方法开始");
            Thread.sleep(5000);
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  方法开始");
            Thread.sleep(5000);
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  方法结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
