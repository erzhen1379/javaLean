package leaning.jdk.jvmerror;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试jvm 崩溃
 */
public class JvmErrorTest {
    public static void main(String[] args) {
        System.out.println("测试jvm异常");
        //HeapOOMTest();
        HashMapLeakTest();
    }

    /**
     * OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，而且每次回收的效果都非常一般。GC 后，堆内存的实际占用呈上升趋势。
     * <p>
     * <p>
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * at java.util.Arrays.copyOf(Arrays.java:3332)
     * at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
     * at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:448)
     * at java.lang.StringBuilder.append(StringBuilder.java:136)
     */
    private static void HeapOOMTest() {
        Map<Object, Object> hashMap = new HashMap<>();
        int counter = 1;
        while (true) {
            hashMap.put("key" + String.valueOf(counter), "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "而且每次回收的效果都非常一般。" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC " +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 " +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC " +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "OOM 一般是内存泄漏引起的，表现在 GC 日志里，一般情况下就是 GC 的时间变长了，" +
                    "而且每次回收的效果都非常一般。GC 后，堆内存的实际占用呈上升趋势。而且每次回收的效果都非常一般。" +
                    "GC 后，堆内存的实际占用呈上升趋势。而且每次回收的效果都非常一般。GC 后，堆内存的实际占用呈上升趋势。" + String.valueOf(counter));
            counter++;
            System.out.println(counter);
        }
    }

    /**
     *忘记了重写对象的hashCode和equals方法，就会产生内存泄漏。
     */
    private static void HashMapLeakTest() {

        Map<Key, Integer> map = new HashMap<>();
         //上海
        map.put(new Key("1"), 1);
        map.put(new Key("2"), 2);
        map.put(new Key("3"), 3);
        Integer integer = map.get(new Key("2"));
        System.out.println(integer);
    }
    public static class Key {
        String title;

        public Key(String title) {
            this.title = title;
        }
    }




}
