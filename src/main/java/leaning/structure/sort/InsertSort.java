package leaning.structure.sort;

import java.util.Arrays;

/**
 * 插入排序
 * O (n^2)
 */
public class InsertSort {
    public static void main(String[] args) {
       //定义待插入的数
        int arr[] = {3, 2, 1, 0, 20, 2, 4, 2, 4};
        for (int i=1;i<arr.length;i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1; //即arr[1]前面的下标
            //给insertVal找到插入位置
            //1，insertIndex>=0保证在给insertVal找到插入位置，不越界
            //2,insertVal<arr[insertIndex]待插入数，还没找到插入位置
            //3需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//找到插入位置
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            arr[insertIndex+1]=insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }
}
