package leaning.jvmtool.arthas;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * 模拟热点代码
 *
 * @Author <a href="https://www.wdbyte.com">https://www.wdbyte.com</a>
 */
public class HotCode {

    private static volatile int value;

    private static Object array;

    public static void main(String[] args) {
        while (true) {
            hotmethod1();
            hotmethod2();
            hotmethod3();
            // hotmethod4();
            allocate();
        }
    }

    /**
     * 生成 6万长度的数组
     */
    private static void allocate() {
        array = new int[6 * 1000];
        array = new Integer[6 * 1000];
    }

    /**
     * 生成一个UUID
     */
    private static void hotmethod3() {
        ArrayList<String> list = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-", "");
        list.add(str);
    }

    private static void hotmethod4() {
        int i = 0;
        while (true) {
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i % 1000 == 0) {
                i = 1;
            }
        }
    }

    /**
     * 数字累加
     */
    private static void hotmethod2() {
        value++;
    }

    /**
     * 生成一个随机数
     */
    private static void hotmethod1() {
        Random random = new Random();
        int anInt = random.nextInt();
    }

}
