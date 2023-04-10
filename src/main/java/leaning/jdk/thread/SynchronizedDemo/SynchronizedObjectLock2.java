package leaning.jdk.thread.SynchronizedDemo;


import java.util.Date;

public class SynchronizedObjectLock2 implements Runnable {
    static SynchronizedObjectLock2 instence = new SynchronizedObjectLock2();

    @Override
    public void run() {
        function();
    }

    //synchronized用在普通方法上，默认的锁就是this，当前实例
    public synchronized void function() {
        System.out.println(new Date() +"线程:" + Thread.currentThread().getName() + " 开始运行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(new Date() +"线程:" + Thread.currentThread().getName() + " 结束运行");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instence);
        Thread t2 = new Thread(instence);
        t1.start();
        t2.start();
    }
}
