package leaning.jdk.thread.threadstatus;

public class Mythread05 extends Thread{
    @Override
    public void run() {
        synchronized (LockTest.lock){
            try {
                LockTest.lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
