package leaning.structure.leetCode.huawei;

import java.util.Scanner;

/**
 * 坐标移动
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(";");
        int W = 0;
        int H = 0;
        for (int i = 0; i < strs.length; i++) {
            //此处匹配正则表达式
            //注意正则表达式
            String res = "[ADWS]\\d{1}\\d?";
            if (strs[i].matches(res)) {
                String commod = String.valueOf(strs[i].charAt(0));
                int num = Integer.parseInt(strs[i].substring(1, strs[i].length()));
                if (commod.equals("A")) {
                    //注意String 转int
                    W = W - num;
                }
                if (commod.equals("S")) {
                    //注意String 转int
                    H = H - num;
                }
                if (commod.equals("W")) {
                    //注意String 转int
                    W = W + num;
                }
                if (commod.equals("D")) {
                    //注意String 转int
                    H = H + num;
                }
            }
        }
        System.out.println("(" + W + "," + H + ")");


    }
}
