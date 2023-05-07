package leaning.jdk.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 底层：数组+链表
 * 线程不安全
 */
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("hashMap 学习");

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "张三");
        hashMap.put("2", "李四");
        hashMap.put("3", "王五");

        //1.直接取值
        System.out.println(hashMap.get("1"));
        //2.普遍使用，二次取值
        for (String key : hashMap.keySet()) {
            System.out.println("key= " + key + " value= " + hashMap.get(key));
        }
        //3.通过Map.entrySet使用iterator遍历key和value：
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key= " + next.getKey() + "  value=" + next.getValue());
        }
        //4.推荐，尤其是容量大时
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + "  value=" + entry.getValue());
        }

        //5.通过Map.values()遍历所有的value，但不能遍历key
        for (String v : hashMap.values()) {
            System.out.println("value :" + v);
        }
        //6.foreach 遍历
        hashMap.forEach((key, value) -> {
            System.out.println("key=" + key + " value=" + value);
        });
        System.out.println("---------34------------");
        for (Map.Entry entry:hashMap.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println("---------34------------");
        System.out.println("----------------测试hashmap线程安全--------------------");
        HashMap<String, String> map = new HashMap<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 200; i++) {
                    map.put(i + "", i + "");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i <= 200; i++) {
                    map.put(i + "", i + 1 + "");
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map.forEach((key, value) -> {
            System.out.println("key=" + key + " value=" + value);
        });
    }

}


