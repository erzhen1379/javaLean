package leaning.jdk.collection.set;

/**
 *
 */

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        //如果含有当前，添加失败，则为true
        boolean add = treeSet.add(2);
        System.out.println(add);
        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}