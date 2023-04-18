package leaning.jdk.thread.threadstatus;

import java.util.Date;

public class MyService {
    synchronized static public void serviceMethod() {
        try {
            System.out.println(new Date() + Thread.currentThread().getName() + " 进入业务方法！");
            Thread.sleep(10000);

            System.out.println(new Date() + Thread.currentThread().getName() + " 结束业务方法！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
