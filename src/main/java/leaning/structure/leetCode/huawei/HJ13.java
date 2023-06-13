package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 句子逆序
 */
public class HJ13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        String strn="";
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.println(str[i]);
            strn=strn+str[i]+" ";
        }
        System.out.println(strn);

    }
}
