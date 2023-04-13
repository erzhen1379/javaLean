package leaning.structure.recursion;

/**
 * 八皇后问题
 */
public class Queue8 {
    //定义一max表示有多少个皇后
    int max = 8;
    //定义一个数组，保存皇后放置的位置的结果，比如arr={0，}
    int[] array = new int[max];
    static int count=0;
    static int judge=0;
    public static void main(String[] args) {
//测试
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法"+count);
        System.out.println("冲突："+judge);
    }
    private void check(int n) {
        if (n == max) { //n=8,其实8个皇后就已经放好
            print();
            count++;
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            //判断当放置地n个皇后到第i列时候，是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行array[n]=i;即将第n个皇后，放置在本行得 后移的一个位置
        }
    }
    //查看当我们放置n个皇后，就去检测该皇后是否和前面已经摆放皇后冲突
    private boolean judge(int n) {
        judge++;
        for (int i = 0; i < n; i++) {
            //说明
            //1.array[i]==array[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            ////2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     */
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }
}
