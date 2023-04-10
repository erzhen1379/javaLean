package leaning.jdk.thread;

import java.util.concurrent.TimeUnit;

public class Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance = balance;
    }

    public double getBalance(String name) {
        return this.balance;
    }

    public /*synchronized*/ static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> account.set("zhangsan", 100.0)).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(account.getBalance("zhangsan"));
    }
}
