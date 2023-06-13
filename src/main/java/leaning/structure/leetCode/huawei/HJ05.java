package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 数据范围：保证结果在
 * <p>
 * 输入一个十六进制的数值字符串。
 */
public class HJ05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2, s.length()), 16));
        }
    }
}
