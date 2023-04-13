package leaning.structure.leetCode;

/**
 * 回文数
 */
public class HuiWen {
    public static void main(String[] args) {
        int a = 1215;
        System.out.println(isHuiWen(a));

    }


    public static boolean isHuiWen(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int rev = 0;
        int tmp = x;
        while (tmp != 0) {
            rev *= 10;
            rev += tmp % 10;
            tmp /= 10;
        }
        return rev == x;
    }

}
