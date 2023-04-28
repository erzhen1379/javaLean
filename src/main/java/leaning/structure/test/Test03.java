package leaning.structure.test;

/**
 * 排序算法
 */
public class Test03 {
    public static void main(String[] args) {
        int[] arr = {9, 4, 5, 1, 6, 2, 4, 2, 0, 3};
        extracted(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void extracted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int z = 0; z < arr.length; z++) {
            System.out.print(arr[z] + "\t");
        }
    }
}