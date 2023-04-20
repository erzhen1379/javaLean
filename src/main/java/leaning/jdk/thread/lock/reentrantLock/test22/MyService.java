package leaning.jdk.thread.lock.reentrantLock.test22;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public Lock lock;

    public MyService(Boolean fair) {
        lock = new ReentrantLock();
    }

    public void waitMethod() {
        try {


            if (lock.tryLock(30, TimeUnit.SECONDS)) {
                System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  开始获得锁");
                Thread.sleep(1000);
                System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  结束获得锁");
            } else {
                System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  没获得锁");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
