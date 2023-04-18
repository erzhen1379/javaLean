package leaning.jdk.thread.threadstatus;

/**
 * 测试线程几种状态
 */
public class Mythread01 extends Thread {
    public Mythread01() {
        System.out.println("构造方法中状态 ：Thread.currentThread().getState()= " + Thread.currentThread().getState());
        System.out.println("构造方法中状态 +this.getState() " + this.getState());
    }

    @Override
    public void run() {
        System.out.println("run 方法中的状态："+Thread.currentThread().getState());
    }
}
