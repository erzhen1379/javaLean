package leaning.jdk.thread.lock.reentrantLock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建两个线程，创建方式自选；
 * 两个线程同时执行代码逻辑；
 * 代码逻辑使用 boolean tryLock () 方法，如果获取到锁，执行打印当前线程名称，并沉睡 5000 毫秒；如果未获取锁，则打印 timeout，并处理异常信息；
 * 观察结果并进行分析；
 * 修改代码，使用 boolean tryLock (long time, TimeUnit unit) 方法，设置时间为 4000 毫秒；
 * 观察结果并进行分析；
 * 再次修改代码，使用 boolean tryLock (long time, TimeUnit unit) 方法，设置时间为 6000 毫秒；
 */
public class ReentrantLockTest01 implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();//创建 lock 实例

    @Override
    public void run() {
        //尝试获取锁，获取成功则进行执行，不成功执行finally模块
        try {
            if (lock.tryLock()) {
                System.out.println(new Date() + " 线程:" + Thread.currentThread().getName() + "  -->");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lock.unlock();
            } catch (Exception e) {
                System.out.println(new Date() + " 线程:" + Thread.currentThread().getName() + "  未获取到锁，释放锁抛出异常");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest01 reentrantLockTest = new ReentrantLockTest01();
        Thread t1 = new Thread(reentrantLockTest, "t1");
        Thread t2 = new Thread(reentrantLockTest, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束");
        //结果分析：从打印的结果来看， Thread-1 获取了锁权限，而 Thread-0 没有获取锁权限，这就是 tryLock，没有获取到锁资源则放弃执行，直接调用 finally。
    }
}