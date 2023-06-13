package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * HJ4 字符串分隔
 * <p>
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 */


public class HJ04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line.length() > 8) {
            System.out.println(line.substring(0, 8));
            line = line.substring(8, line.length());
        }
        String str = "";
        for (int i = 0; i < 8 - line.length(); i++) {
            str = str + 0;
        }
        System.out.println(line + str);
    }
}
