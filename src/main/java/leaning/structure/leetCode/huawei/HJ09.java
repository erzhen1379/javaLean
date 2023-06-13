package leaning.structure.leetCode.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 */
public class HJ09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = "";
        char[] chars = (num + "").toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!str.contains(chars[i] + "")) {
                str = str + chars[i];
            }
        }
        System.out.println(str);

    }
}
