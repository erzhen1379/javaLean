package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 数字颠倒
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str = str + s.charAt(i);
        }
        System.out.println(str);
    }
}
