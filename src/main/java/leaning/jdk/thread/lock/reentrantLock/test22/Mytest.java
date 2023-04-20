package leaning.jdk.thread.lock.reentrantLock.test22;

import java.util.Date;

/**
 * 测试tryLock(long time, TimeUnit)使用
 * 作用： 是嗅探拿到锁，如果在固定时间获得锁，就返回true
 */
public class Mytest {
    public static void main(String[] args) {


        final MyService myService = new MyService(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                System.out.println(new Date() + " : ThreadName  " + Thread.currentThread().getName() + " 调用 waitMehtod时间");
                myService.waitMethod();

            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("1");
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.setName("2");
        thread2.start();
    }
}
