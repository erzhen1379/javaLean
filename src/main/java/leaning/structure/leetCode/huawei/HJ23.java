package leaning.structure.leetCode.huawei;

import java.util.*;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char word = line.charAt(i);
            if (hashMap.containsKey(word)) {
                Integer count = hashMap.get(word);
                hashMap.put(word, count + 1);
            } else {
                hashMap.put(line.charAt(i), 1);
            }
        }
        //计算最小值
/*        int count = 0;
        int min = 1;
        //遍历hashmap
        for (Character car : hashMap.keySet()) {
            count++;
            Integer value = hashMap.get(car);
            if (count == 1) {
                min = value;
            }
            if (value <= min) {
                min = value;
            }
        }*/
        //或者使用集合
        Collection<Integer> values = hashMap.values();
        Integer min = Collections.min(values);
        for (Character car : hashMap.keySet()) {
            Integer value = hashMap.get(car);
            if (value == min) {
                line = line.replace(String.valueOf(car), "");
            }
        }
        System.out.println(line);
//aabcddd
    }
}
