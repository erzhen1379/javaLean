package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 */
public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //将10进制转2进制
        String s = Integer.toBinaryString(num);
        System.out.println(s);
        System.out.println(s.length()-s.replace("1","").length());
    }

}
