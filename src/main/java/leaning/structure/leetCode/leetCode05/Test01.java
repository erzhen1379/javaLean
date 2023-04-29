package leaning.structure.leetCode.leetCode05;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 字符串问题
 * （1）题目：
 * 给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，那么str1与str2互为变形词。请实现函数判断两个字符串是否互为变形词。
 * （2）举例：
 * str1=＂123＂，str2=＂231＂，返回true。str1=＂123＂，str2=＂2331＂，返回false。
 * （3）思路：
 * ①如果字符串str1和str2长度不同，直接返回false。
 * ②如果长度相同，假设出现字符的编码值在0～255之间，那么先申请一个长度为256的整型数组map，map[a]=b代表字符编码为a的字符出现了b次，初始时map[0…255]的值都是0。
 * ③然后遍历字符串str1，统计每种字符出现的数量，比如遍历到字符’a’，其编码值为97，则令map[97]++。这样map就成了str1中每种字符的词频统计表
 * ④然后遍历字符串str2，每遍历到一个字符，都在map中把词频减下来，比如遍历到字符’a’，其编码值为97，则令map[97]–，如果减少之后的值小于0，直接返回false。如果遍历完str2，map中的值也没出现负值，则返回true。
 */
public class Test01 {
    public static void main(String[] args) {
        String str1 = "adaga";
        String str2 = "adgaa";
        boolean b = idDeformation(str1, str2);
        System.out.println(b);

    }

    public static boolean idDeformation(String str1, String str2) {
        //1.判断字符串长度
        if (str1.length() != str2.length()) {
            return false;
        }
        //2.将数据添加到到hashmap中
        Map<String, Integer> map1 = new TreeMap<>();
        for (int i = 0; i < str1.length(); i++) {
            Integer count = 0;
            if (map1.containsKey(String.valueOf(str1.charAt(i)))) {
                count = map1.get(String.valueOf(str1.charAt(i)));
                System.out.println(String.valueOf(count));
                map1.put(String.valueOf(str1.charAt(i)), count + 1);
            } else {
                map1.put(String.valueOf(str1.charAt(i)), 1);
            }
        }
        Map<String, Integer> map2 = new TreeMap<String, Integer>();
        for (int i = 0; i < str2.length(); i++) {
            Integer count = 0;
            if (map2.containsKey(String.valueOf(str2.charAt(i)))) {
                count = map2.get(String.valueOf(str2.charAt(i)));
                map2.put(String.valueOf(str2.charAt(i)), count + 1);
            } else {
                map2.put(String.valueOf(str2.charAt(i)), 1);
            }
        }
        return map1.equals(map2);
    }
}
