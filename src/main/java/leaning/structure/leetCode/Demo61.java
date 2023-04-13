package leaning.structure.leetCode;

public class Demo61 {
    public static void main(String[] args) {
        int sqert = sqert(101);
        System.out.println(sqert);
    }

    public static int sqert(int x) {
        long left = 0;
        long right = x / 2 + 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long result = mid * mid;
            if (result == (long) x) {
                return (int) mid;
            } else if (result > (long) x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
