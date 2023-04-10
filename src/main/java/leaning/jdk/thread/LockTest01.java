package leaning.jdk.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 测试锁中异常，然后开始释放锁，
 */
public class LockTest01 {
    int count = 0;

    synchronized void modifyCount() {
        System.out.println(new Date() + " " + Thread.currentThread().getName());
        while (true) {
            count++;
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": count" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 5) {
                int i = 1 / 0;
                System.out.println(i);

            }
        }
    }

    public static void main(String[] args) {
        LockTest01 lockTest01 = new LockTest01();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                lockTest01.modifyCount();
            }
        };
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(r,"t2").start();
    }
}
