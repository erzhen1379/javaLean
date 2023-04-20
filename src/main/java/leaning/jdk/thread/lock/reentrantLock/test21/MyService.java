package leaning.jdk.thread.lock.reentrantLock.test21;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public Lock lock;

    public MyService(Boolean fair) {
        lock = new ReentrantLock();
    }

    public void waitMethod() {
        if (lock.tryLock()) {
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  获得锁");
        } else {
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + "  没获得锁");
        }
    }


}
