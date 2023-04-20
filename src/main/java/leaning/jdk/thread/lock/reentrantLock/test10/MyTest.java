package leaning.jdk.thread.lock.reentrantLock.test10;

/**
 * 4.1.10测试锁公平，非公平（默认）
 */
public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService(false); //非公平锁
        //  MyService myService = new MyService(true);  //公平锁
        MyThread[] arr1 = new MyThread[100];
        MyThread[] arr2 = new MyThread[100];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new MyThread(myService);
            arr1[i].setName("arr1+++" + (i + 1));
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i].start();
        }
        Thread.sleep(500);
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = new MyThread(myService);
            arr2[i].setName("arr2----" + (i + 1));
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i].start();
        }
    }
}
