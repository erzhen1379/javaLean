package leaning.structure.leetCode.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足1<=n<=100
 */
public class HJ21 {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("abc", "2");
        hashMap.put("def", "3");
        hashMap.put("ghi", "4");
        hashMap.put("jkl", "5");
        hashMap.put("mno", "6");
        hashMap.put("pqrs", "7");
        hashMap.put("tuv", "8");
        hashMap.put("wxyz", "9");
        hashMap.put("0", "0");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        String strNew = "";
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                for (String key : hashMap.keySet()) {
                    if (key.contains(String.valueOf(chars[i]))) {
                        strNew = strNew + hashMap.get(key);
                    }
                }
            } else if (chars[i] >= 'A' && chars[i] < 'Z') {
                strNew = strNew + (char) (chars[i] + 33);
            } else if (chars[i] == 'Z') {
                strNew = strNew + "a";
            } else {
                strNew = strNew + chars[i];
            }
        }
        System.out.println(strNew);
    }
}
