package leaning.jvmerror;

public class CPUSpikeDemo {
    public static void start() {
        new CPUSpikerThread().start();
        new CPUSpikerThread().start();
        new CPUSpikerThread().start();
        new CPUSpikerThread().start();
        new CPUSpikerThread().start();
        new CPUSpikerThread().start();
        System.out.println("6 threads launched!");
    }
}

class CPUSpikerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("test");
        }
    }
}