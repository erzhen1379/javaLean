package leaning.jdk.thread.threadstatus;

import org.testng.annotations.Test;

import java.util.Date;

/**
 *测试线程的状态 new running wait wait_time blocked  terminated
 */
public class MyThreadTest {

    public static void main(String[] args) throws Throwable {
        MyThreadTest myThreadTest = new MyThreadTest();
        myThreadTest.testNewRunningTerminated();
        myThreadTest.testTimeWait();
        myThreadTest.testBlocked();


    }

    /**
     * 测试new running terminated
     *
     * @throws InterruptedException
     */
    @Test
    public void testNewRunningTerminated() throws InterruptedException {
        Mythread01 mythread = new Mythread01();
        System.out.println("状态1  :" + mythread.getState());
        Thread.sleep(1000);
        mythread.start();
        Thread.sleep(1000);
        System.out.println("状态2： " + mythread.getState());
    }

    /**
     * 代表线程执行Thread.sleep()
     * 测试time_wait状态
     *
     * @throws InterruptedException
     */
    @Test
    public void testTimeWait() throws InterruptedException {
        Mythread02 mythread02 = new Mythread02();
        mythread02.start();
        Thread.sleep(1000);
        System.out.println("当前主线程状态： " + mythread02.getState());
    }

    /**
     * 验证某个线程在等待锁时候
     *
     * @throws Throwable
     */
    @Test
    public void testBlocked() throws Throwable {

        Mythread03 mythread03 = new Mythread03();
        mythread03.setName("mythread03");
        mythread03.start();
        Thread.sleep(1000);

        Mythread04 mythread04 = new Mythread04();
        mythread04.setName("mythread04");
        mythread04.start();

        Thread.sleep(1000);
        System.out.println(new Date() + "当前线程 mythread03 状态：" + mythread03.getState());
        System.out.println(new Date() + "当前线程 mythread04 状态：" + mythread04.getState());

    }

    /**
     * 当线程执行object.wait方法后，线程所处于状态
     * @throws InterruptedException
     */
    @Test
    public void testWaiting() throws InterruptedException {
        Mythread05 mythread = new Mythread05();
        mythread.start();
        Thread.sleep(1000);
        System.out.println(new Date() + "当前线程 状态：" + mythread.getState());
        Thread.sleep(10000);
        System.out.println(new Date() + "当前线程 状态：" + mythread.getState());
    }
}
