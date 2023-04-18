package leaning.jdk.thread.threadstatus;

public class Mythread02 extends Thread {

    @Override
    public void run() {

        try {
            System.out.println("线程开始：");
            Thread.sleep(10000);
            System.out.println("线程结束： ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
