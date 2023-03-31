package leaning.press;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadStressTest {

    public static void main(String[] args) throws InterruptedException {
        int threads = 10; // 设置线程数
        int requestsPerThread = 100; // 每个线程发起的请求数

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            executorService.submit(() -> {
                try {
                    startLatch.await(); // 等待所有线程准备好
                    for (int j = 0; j < requestsPerThread; j++) {
                        // 在此处添加需要压测的方法调用，例如：myTestMethod();
                        System.out.println("111111111111");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endLatch.countDown(); // 完成一个线程的任务
                }
            });
        }

        long startTime = System.currentTimeMillis();
        startLatch.countDown(); // 开始压测
        endLatch.await(); // 等待所有线程完成
        long endTime = System.currentTimeMillis();

        System.out.println("压测完成，耗时: " + (endTime - startTime) + "毫秒");
        executorService.shutdown();
    }
}