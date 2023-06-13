package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if (!str.contains(chars[i] + "")) {
                str = str + chars[i];
            }
        }
        System.out.println(str.length());
    }
}
