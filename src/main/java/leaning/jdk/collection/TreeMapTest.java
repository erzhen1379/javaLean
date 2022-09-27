package leaning.jdk.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        System.out.println("测试tree map ");
        //TreeMap  是Java集合中的 红黑树结构  其本质上是一个有序表  对传入的数据根据key的值进行排序
        //也正因为它是一种有序的结构  所以我们可以进行相关操作

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(7, "我是7");  //哈希表的创建
        treeMap.put(6, "我是6");
        treeMap.put(5, "我是5");
        treeMap.put(9, "我是9");
        treeMap.put(8, "我是8");
        treeMap.put(1, "我是1");
        treeMap.put(2, "我是2");


        System.out.println(treeMap.containsKey(5));    //进行数据的查询  看在哈希表当中是否含有该数据
        System.out.println(treeMap.get(5));           //获取5所对应的值
        System.out.println(treeMap.firstKey() + "我最小");   //查找值最小的数据


        treeMap.forEach((key, value) -> {
            System.out.println("key=" + key + "  value=" + value);
        });


    }
}
