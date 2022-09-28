package leaning.jdk.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        System.out.println("-------------测试股ConcurrentHashMap --------------");

        System.out.println("----------------测试hashmap线程安全--------------------");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 200; i++) {
                    concurrentHashMap.put(i + "", i + "");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i <= 200; i++) {
                    concurrentHashMap.put(i + "", i + 1 + "");
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        concurrentHashMap.forEach((key, value) -> {
            System.out.println("key=" + key + " value=" + value);
        });
    }
}
