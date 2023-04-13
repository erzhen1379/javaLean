package leaning.structure.queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
//测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}

class CircleArray {
    private int maxSize;  //表示数组最大容量
    //修改后纸箱队列的最后一个元素
    private int front;
    //rear指向队列的最后一个元素
    private int rear;
    private int[] arr; //模拟存放队列

    /**
     * 队列构造器
     *
     * @param arrMaxSize
     */
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;  //默认初始值（系统）为0
        rear = 0;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 将数据直接 加入
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        //将数据直接加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     *
     * @return
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        //front是指向队列的第一个元素
        //1，将front对应值保留到一个临时变量
        //2,将front后移，考虑取模
        //3,将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列的所以数值
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        //思路：从front开始遍历，遍历有多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }


    }

    /**
     * 获取队列的长度
     *
     * @return
     */
    public int size() {
        //rear=1
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     *
     * @return
     */
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }

}