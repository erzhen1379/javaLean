package leaning.structure.leetCode;

import java.util.Arrays;

/**
 * 删除数组重复数据
 */
public class Demo26 {
    public static void main(String[] args) {
        int[] arr = {1,9,1,3,4, 2,4, 6,2,2};
        order(arr);
       /* System.out.println(Arrays.toString(arr));
        reElement(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    public static int removeRepeat(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    num++;
                }
            }
        }
        System.out.println(arr.length - num + 1);
        return arr.length - num + 1;
    }

    public static int reElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    reRepeat(arr, i);
                }
            }
        }
        return 0;
    }

    public static int[] reRepeat(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return arr;
    }

    public static int[] order(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            for (int j=i;j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j+1]=arr[j];
                    arr[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
