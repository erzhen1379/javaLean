package leaning.structure.queue.test01;

/**
 * 定义一个队列
 */
public class Queue {
    //定义队列最大容量
    int maxSize;
    //队列头
    int front;
    //队列尾
    int rear;
    //存放数据
    int[] arr;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.rear = -1;
        this.front = -1;
    }


    public void add(int i) {
        if (isFull()) {
            System.out.println("-----队列已满，禁止加入--------");
            return;
        }
        rear++;
        System.out.println(rear);
        arr[rear] = i;
    }

    public boolean isFull() {
        if (rear + 1 >= maxSize) {
            return true;
        }
        return false;
    }

    public void list() {
        if (idEmpty()) {
            System.out.println("队列为null");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public boolean idEmpty() {
        if (front == rear) {
            System.out.println("-----队列为空------");
            return true;
        }
        return false;
    }

    public void getHead() {
        if (idEmpty()) {
            System.out.println("队列头节点为null");
        }
        System.out.println(arr[front + 1]);
    }


    public int getRearQueue() {
        if (idEmpty()) {
            System.out.println("队列为null，无法出队列");
        }
        System.out.println("获取队尾部数据:" + arr[rear]);
        front++;
        return arr[front];
    }

    public void outQueue() {
    }
}
