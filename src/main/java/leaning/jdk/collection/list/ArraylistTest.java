package leaning.jdk.collection.list;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 1.底层是数组：查询效率比较高，随机更改效率低
 * 2.list接口:有序，可以重复
 */
public class ArraylistTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, 0);
        arrayList.add(1, 1);


        list(arrayList);
        System.out.println("-----1测试是否可以重复添加---------");
        //1.测试是否可以重复加入
        arrayList.add(2, 9);
        arrayList.add(3, 1);
        list(arrayList);


    }

    private static void list(ArrayList arrayList) {
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

}
