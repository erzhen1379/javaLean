package leaning.jdk.thread.lock.reentrantLock.test21;

/**
 * 测试tryLock()使用
 * 作用： 是嗅探拿到锁，如果当前线程被其他程序拿到锁，返回false，那么继续执行下面的代码，而不是阻塞状态
 */
public class Mytest {
    public static void main(String[] args) {


        final MyService myService = new MyService(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
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
