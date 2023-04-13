package leaning.structure.leetCode;

/**
 * 搜索插入位置
 */
public class Demo35 {
    public static void main(String[] args) {
        System.out.println();
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsertLocation(arr, 0));
    }

    public static int searchInsertLocation(int[] arr, int a) {
        if (a < arr[0]) {
            return 0;
        }
        if (a > arr[arr.length - 1]) {
            return arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return i;
            }
            if (a > arr[i]&&a<=arr[i+1]) {
                return i + 1;
            }
        }
        return -1;
    }
}
