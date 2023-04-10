package leaning.jdk.thread.lockDemo;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    Lock lock = new ReentrantLock();

    public void method(Thread thread) {
        try {
            lock.lock();
            System.out.println(new Date() + " 线程名：" + thread.getName() + "开始获得锁");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(new Date() + " 线程名：" + thread.getName() + "开始释放锁");
        }


    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        //线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");
        //线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t2");
        t1.start();
        t2.start();


    }

}
