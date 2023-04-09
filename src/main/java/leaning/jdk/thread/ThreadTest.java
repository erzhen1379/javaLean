package leaning.jdk.thread;

/**
 * 继承Thread类并重写run()方法实现多线程
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":执行" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest thread1 = new ThreadTest();
        ThreadTest thread2 = new ThreadTest();
        //设置线程的名称
        thread1.setName("张三");
        thread2.setName("李四");

        //设置线程的优先级，默认5，最小为1，最大为10
        thread1.setPriority(6);
        thread2.setPriority(3);

        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        System.out.println("---------测试线程join方法1------------");
        ThreadTest thread3 = new ThreadTest();
        System.out.println(thread3.getState());
        thread3.start();
        //表示同级别，或者级别更好的才可以抢到
        Thread.yield();
        System.out.println(thread3.getState());
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                try {
                    //如果i>10后，开始启动线程
                  //  System.out.println(thread3.getState());
                    thread3.join();
                  //  System.out.println(thread3.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程：" + Thread.currentThread().getName() + " i-->" + i);
        }

    }
}
