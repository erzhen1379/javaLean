package leaning.structure.leetCode.huawei;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
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
            boolean flag = true;
            int count = 0;
            Pattern p1 = Pattern.compile("[A-Z]");
            Pattern p2 = Pattern.compile("[a-z]");
            Pattern p3 = Pattern.compile("[0-9]");
            Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
            boolean isA = false;
            boolean isa = false;
            boolean isNum = false;
            boolean isOther = false;
            for (int i = 0; i < chars.length; i++) {
                if (p1.matcher(String.valueOf(chars[i])).find()) {
                    if (isA == false) {
                        count++;
                    }
                    isA = true;
                }
                if (p2.matcher(String.valueOf(chars[i])).find()) {
                    if (isa == false) {
                        count++;
                    }
                    isa = true;
                }
                if (p3.matcher(String.valueOf(chars[i])).find()) {
                    if (isNum == false) {
                        count++;
                    }
                    isNum = true;
                }
                if (p4.matcher(String.valueOf(chars[i])).find()) {
                    if (isOther == false) {
                        count++;
                    }
                    isOther = true;
                }
                //判断长度是否
                if (i + 1 < chars.length) {
                    String tmp = chars[i] + "" + chars[i + 1];
                    if (str.replace(tmp, "").length() != (str.length() - 2)) {
                        System.out.println(tmp);
                        flag = false;
                    }
                }
            }
            if (count >= 3 && flag) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }

    }
}
