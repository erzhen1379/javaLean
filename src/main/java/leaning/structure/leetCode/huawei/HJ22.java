package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足 1≤n≤100
 */
public class HJ22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            int num = scanner.nextInt();
            count++;
            if (count == 10) {
                break;
            }
            //注意判断字符串是否相等
            if (num == 0) {
                break;
            }
            System.out.println(num / 3);
            int empty = num % 3;

        }
    }
}
