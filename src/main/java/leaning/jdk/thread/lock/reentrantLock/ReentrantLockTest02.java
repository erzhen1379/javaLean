package leaning.jdk.thread.lock.reentrantLock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * 场景介绍：通过模拟一个场景假设，来了解公平锁与非公平锁。
 * <p>
 * 假设线程 A 已经持有了锁，这时候线程 B 请求该锁将会被挂起；
 * 当线程 A 释放锁后，假如当前有线程 C 也需要获取该锁，如果采用非公平锁方式，则根据线程调度策略，线程 B 和线程 C 两者之一可能获取锁，这时候不需要任何其他干涉；
 * 而如果使用公平锁则需要把 C 挂起，让 B 获取当前锁，因为 B 先到所以先执行。
 */
public class ReentrantLockTest02 {
    private Lock lock = new ReentrantLock();

    //公平锁
    ReentrantLock pairLock = new ReentrantLock(true);
    //非公平锁
    ReentrantLock pairLock1 = new ReentrantLock(false);
    //如果构造函数不传递参数，则默认是非公平锁。
    ReentrantLock pairLock2 = new ReentrantLock();

    public void doBussiness() {
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + " 开始获取锁");
            lock.lockInterruptibly(); //调用lockInterruptibly方法，表示可中断等待
            System.out.println(name + " 得到锁，开工干活");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(name + " : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " 被中断");
        } finally {
            try {
                lock.unlock();
                System.out.println(name + " 释放锁");
            } catch (Exception e) {
                System.out.println(name + " : 没有得到锁的线程运行结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLockTest02 lockTest = new ReentrantLockTest02();
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                lockTest.doBussiness();
            }
        });
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                lockTest.doBussiness();
            }
        });

        t0.start();
        Thread.sleep(20);
        t1.start();
        t1.interrupt();
    }
}
