package leaning.structure.stack;

public class ArrayStack {
    private int maxSize;  //栈大小
    private int[] stack;  //数组，数组模拟栈，数据就放在该数组中
    private int top = -1;  //top表示栈顶，初始化为-1

    /**
     * 构造器
     *
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈满了
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        //判断栈为空
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈pop
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈，遍历是需要从栈顶开始显示数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}
