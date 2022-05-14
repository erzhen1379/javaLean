package leaning.jdk;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 测试1
 */
public class UnsafeLean {
    public static void main(String[] args) {

        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
