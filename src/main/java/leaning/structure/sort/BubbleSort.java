package leaning.structure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度O(n²)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 0, 20,2,4,2,4};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        int tmp = 0;
        boolean flag=false;  //此处添加优化，如果其中一次循环中没有发生交行，说明已经排好序了
        for (int i = 0; i < arr.length - 1; i++) { //循环n-1次
            for (int j = 0; j < arr.length - 1 - j; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag){
                System.out.println(i);
                break;
            }else {
                flag=false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
