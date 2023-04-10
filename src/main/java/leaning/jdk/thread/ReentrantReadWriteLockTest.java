package leaning.jdk.thread;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
读写锁简介：

对共享资源有读和写的操作，且写操作没有读操作那么频繁。在没有写操作的时候，多个线程同时读一个资源没有任何问题，所以应该允许多个线程同时读取共享资源；但是如果一个线程想去写这些共享资源，就不应该允许其他线程对该资源进行读和写的操作了。

针对这种场景，JAVA的并发包提供了读写锁ReentrantReadWriteLock，它表示两个锁，一个是读操作相关的锁，称为共享锁；一个是写相关的锁，称为排他锁，描述如下：

线程进入读锁的前提条件：

没有其他线程的写锁，

没有写请求或者有写请求，但调用线程和持有锁的线程是同一个。

线程进入写锁的前提条件：

没有其他线程的读锁

没有其他线程的写锁

而读写锁有以下三个重要的特性：

（1）公平选择性：支持非公平（默认）和公平的锁获取方式，吞吐量还是非公平优于公平。

（2）重进入：读锁和写锁都支持线程重进入。

（3）锁降级：遵循获取写锁、获取读锁再释放写锁的次序，写锁能够降级成为读锁。

实现效果：
-----------------------------------
 */
public class ReentrantReadWriteLockTest {

    //读写锁对象
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    //获得读锁
    private ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    //获得写锁
    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    //执行read方法时，需要获取读锁，而此时其他线程均可访问该方法而不被阻塞。
    //可以说这是一个类似于concurrentHashMap的原型，但它的效率肯定没有concurrentHashMap高，但比HashTable要强一些 。
    public void read() {
        readLock.lock();
        try {
            System.out.println(new Date() + "线程 " + Thread.currentThread().getName() + " 进入了读方法。。。");
            Thread.sleep(3000);
            System.out.println(new Date() + "线程 " + Thread.currentThread().getName() + " 退出了读方法。。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    //执行write方法时，必须提前获取写锁，当获取写锁之后，其他线程对于读锁和写锁的获取均被阻塞，只有写锁释放后，其他读操作才能继续。
    public void write() {
        writeLock.lock();
        try {
            System.out.println(new Date() + "线程 " + Thread.currentThread().getName() + " 进入了写方法。。。");
            Thread.sleep(3000);
            System.out.println(new Date() + "线程 " + Thread.currentThread().getName() + " 退出了写方法。。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest lockTest = new ReentrantReadWriteLockTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.read();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.read();
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.write();
            }
        }, "t3");

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.write();
            }
        }, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}