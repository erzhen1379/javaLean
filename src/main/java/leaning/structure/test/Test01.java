package leaning.structure.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计单词出现次数
 */
public class Test01 {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "a", "d", "b", "f", "d"};

        System.out.println("----------通过集合-------------");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            Integer count = hashMap.get(arr[i]);
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], count + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        hashMap.forEach((key, value) -> {
            System.out.println(key + "|" + value);
        });
    }
}