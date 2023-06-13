package leaning.structure.leetCode.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 密码验证合格程序
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        if (str.length() < 8) {
            System.out.println("NG");
        } else {
            int count = 0;
            Pattern p1 = Pattern.compile("[A-Z]");
            Pattern p2 = Pattern.compile("[a-z]");
            Pattern p3 = Pattern.compile("[0-9]");
            Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
            if (int i=0;i<chars.length;i++){
                System.out.println("111");
            }
        }

    }
}
