package leaning.jdk.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 1.底层双链表：查询效率低，更改效率高
 * 2.list接口：有序，可重复
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("zhangsan");
        linkedList.add("lisi");
        linkedList.add("wangwu");

        list(linkedList);
        System.out.println("--------测试是否可以添加重复元素-------");
        linkedList.add("lisi");
        list(linkedList);

    }

    public static void list(LinkedList linkedList) {
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
