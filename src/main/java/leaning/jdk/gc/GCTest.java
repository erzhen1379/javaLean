package leaning.jdk.gc;


/**
 * -XX:+PrintGCDetails -Xmx200M -Xms200M -Xmn50M -XX:+PrintTenuringDistribution  -XX:+PrintGCDateStamps
 */
public class GCTest {
    public static void main(String[] args) {
        //main方法默认使用 3898K 10%
        System.out.println("第一轮GC");
        createObj30M();//使用方法创建 待方法结束后对象成为待清除的垃圾

        byte[] arr1 = new byte[1024 * 1024 * 2];
        byte[] arr2 = new byte[1024 * 1024 * 2];
        //Eden区100% 第一次触发gc arr1 arr2移动到 from
        createObj2M();

        System.out.println("第二轮GC");
        //第二次想触发gc arr1 arr2已经移动到 from 使eden100%
        createObj30M();
        byte[] arr3 = new byte[1024 * 1024 * 2];
        byte[] arr4 = new byte[1024 * 1024 * 2];
        //第二次触发 gc  arr1 arr2 因为form区内存不够 被移动至老年代  new threshold 7未达到年龄"premature promotion"(过早提升)
        createObj2M();


    }

    /**
     * 创建单个30M的对象
     */
    public static void createObj30M() {
        byte[] arr = new byte[1024 * 1024 * 30];
    }

    /**
     * 创建2m的对象
     */
    public static void createObj2M() {
        byte[] arr = new byte[1024 * 1024 * 2];
    }
}
