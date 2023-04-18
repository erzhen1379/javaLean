package leaning.jdk.normal.whileTest;

/**
 * 、在循环体内使用 函数返回 语句（return），如 while(1){if(c>8) return (XXX);}，当 c>8的时候，程序执行 return，退出函数返回到上级函数。其中返回值 XXX 需要根据 函数类型进行返回。
 */
public class WhileDemo {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            if (i == 5) {
                System.out.println("while 循环退出");
                return;
            }
        }

    }
}
