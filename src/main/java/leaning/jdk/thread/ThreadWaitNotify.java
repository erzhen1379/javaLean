package leaning.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * obj.wait()/obj.wait(long timeout)是Object中的方法，当线程调用wait()方法，当前线程释放对象锁，进入等待队列。
 * obj.notify()/obj.nogifyAll()是Object中的方法，唤醒在此对象上wait()的单个或者所有线程。
 */
public class ThreadWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建DemoTest对象
        DemoTest demoTest = new DemoTest();
        //用线程池创建线程异步执行waitTest方法
        executorService.submit(() -> demoTest.waitTest());
        //用线程池创建线程异步执行notifyTest方法
        executorService.submit(() -> demoTest.notifyTest());
    }

    //测试wait和notify测试demo
    static class DemoTest {
        //唤醒线程
        public synchronized void notifyTest() {
            System.out.println("方法notifyTest开始执行了");
            notify();
            System.out.println("方法notifyTest执行结束了");
        }
        //执行wait操作将线程挂起，注意必须结合synchronized使用
        public synchronized void waitTest() {
            System.out.println("方法waitTest开始执行了");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("方法waitTest执行结束了");
        }
    }

}