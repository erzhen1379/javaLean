package leaning.jdk.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 1.底层是hash表（实际是hashMap）
 * 2.set接口：无序，不可重复
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("zhangsan");
        hashSet.add("lisi");
        hashSet.add("wangwu");
        System.out.println("-------测试是否有序-------");
        list(hashSet);
        System.out.println("-----------测试是否重复可以加入-------------");
        boolean lisi = hashSet.add("lisi");
        //测试，如果重复添加，就会返回一个false
        System.out.println(lisi);
        list(hashSet);
    }

    private static void list(HashSet hashSet) {
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
