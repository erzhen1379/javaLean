package leaning.structure.leetCode;

/**
 * 最大子序和
 */
public class Demo53 {
    public static void main(String[] args) {
        System.out.println();
        int[] arr = {1, 4, -3, 5, 9, 5};
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[] arr) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        //进行向左搜索
        int leftMax = 0;
        int left = index;
        int tmp = 0;

        for (int i = index - 1; i >= 0; i--) {
            tmp = tmp + arr[i];
            if (tmp > leftMax) {
                leftMax = tmp;
            }
        }
        tmp = 0;
        int rightMax = 0;
        for (int i = index + 1; i < arr.length; i++) {
            tmp = tmp + arr[i];
            if (tmp > rightMax) {
                leftMax = tmp;
            }
        }
        if (leftMax <= 0 && rightMax >= 0) {
            return arr[index];
        }
        if (leftMax > 0) {
            max = max + leftMax;
        }
        if (rightMax > 0) {
            max = max + rightMax;
        }
        return max;
    }
}
