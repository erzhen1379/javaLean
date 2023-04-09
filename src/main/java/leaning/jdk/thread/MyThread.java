package leaning.jdk.thread;

public class MyThread {
    //当线程调用wait()方法，当前线程释放对象锁，进入等待队列
    public synchronized void waitTest()  {
        System.out.println("开始调用 wait");
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束调用 wait");
    }
  public  synchronized void notityTest(){
      System.out.println("开始调用notity。。。");
      notify();
      System.out.println("结束调用notity。。。");
  }
}
