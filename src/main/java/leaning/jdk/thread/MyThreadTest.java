package leaning.jdk.thread;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadTest {
    public static void main(String[] args) {
        System.out.println("------开始线程测试-----------");
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyThread myThread1 = new MyThread();
        executorService.submit(() -> myThread1.waitTest());
        System.out.println("执行响应代码");
        executorService.submit(() -> myThread1.notityTest());
        //唤醒线程
    }

    /**
     * 1.测试唤醒线程
     */
    @Test
    public void testWaitAndNotity() {
        System.out.println("------开始线程测试-----------");
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyThread myThread1 = new MyThread();
        executorService.submit(() -> myThread1.waitTest());
        executorService.submit(() -> myThread1.notityTest());
    }

    /**
     * Thread.yield()：一定是当前线程调用此方法，当前线程放弃获取CPU的时间片，由运行态转变为就绪态，让操作系统中再次选择线程执行。
     * 作用：让相同优先级的线程轮流执行，但并不能保证轮流执行，根据解释我们了解到，转成就绪态的的线程还有可能再次选中执行。
     * Thread.yield()方法不会导致阻塞。
     *
     * @throws InterruptedException
     */
    @Test
    public void testYield() throws InterruptedException {
        //测试线程
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "测试线程开始执行。。。");
            try {
                //睡眠5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "测试线程执行结束。。。");
        });
        //测试线程
        thread.start();
        System.out.println(thread.getName() + "开始执行join");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + ": 主线程开始执行");
    }

    /**
     * t.join()/t.join(long millis)：当前线程调用t2.join()方法，当前线程阻塞但是不会释放对象锁，直到t2线程执行完毕或者millis时间到，则当前的线程恢复就绪状态。
     * 作用：让优先级比较高的线程优先执行。
     *
     * @throws InterruptedException
     */
    @Test
    public void testJoin() throws InterruptedException {
        //测试线程
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "测试线程开始执行。。。");
            try {
                //睡眠5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "测试线程执行结束。。。");
        });
        //测试线程
        thread.start();
        System.out.println(thread.getName() + "开始执行join");
        thread.join();
        System.out.println(Thread.currentThread().getName() + ": 主线程开始执行");
    }
}
