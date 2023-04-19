package leaning.jdk.thread.lock.reentrantLock.test01;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    // 创建锁对象
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 定义线程任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 加锁
                lock.lock();
                try {
                    // 打印执行线程的名字
                    System.out.println("线程:" + Thread.currentThread().getName());
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        };
        // 创建多个线程
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }
}