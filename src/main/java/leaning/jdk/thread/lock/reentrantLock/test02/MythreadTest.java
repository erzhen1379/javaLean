package leaning.jdk.thread.lock.reentrantLock.test02;

/**
 * 4.1.2 验证多代码块直接的同步性
 * <p>
 * 结果：
 * 哪个线程持有锁，哪个线程就执行，其他线程只能等待锁被释放时候再次争抢
 */
public class MythreadTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.setName("A");

        threadA.start();
        ThreadAA threadAA = new ThreadAA(myService);
        threadAA.setName("AA");
        threadAA.start();

        ThreadB threadB = new ThreadB(myService);
        threadB.setName("B");
        threadB.start();

        ThreadBB threadBB = new ThreadBB(myService);
        threadBB.setName("BB");
        threadBB.start();

    }
}
