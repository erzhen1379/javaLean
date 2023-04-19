package leaning.jdk.thread.lock.reentrantLock.test01;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试创建reentrantLock
 */
public class MyService01 {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + " i:" + (i + 1));
        }
      /*  try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        lock.unlock();
    }
}
