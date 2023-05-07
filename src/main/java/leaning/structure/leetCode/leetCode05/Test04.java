package leaning.structure.leetCode.leetCode05;

/**
 * 4统计字符串出现频率
 */
public class Test04 {
    public static void main(String[] args) {
        String str = "aabsdada";
        getCountString(str);

    }

    private static void getCountString(String str) {
        char[] chars = str.toCharArray();
        int num = 1;
        String res = String.valueOf(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chars[i]));
            } else {
                num++;
            }
        }
    }

    public static String concat(String str1, String str2, String str3) {
    return str1+"_"+str2;

    }
}

