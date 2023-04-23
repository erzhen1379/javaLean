package leaning.structure.queue.test01;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("---------test queue---------");
        Queue queue = new Queue(4);
        System.out.println("-----判断队列是否为null------");
        queue.idEmpty();
        System.out.println("---------add-----------");
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.add(7);
        System.out.println("----------list--------------");
        queue.list();
        System.out.println("----------get head data---------------");
        queue.getHead();
        System.out.println("-----------get 出队列数据---------------");
        queue.getRearQueue();
        queue.list();
    }
}
