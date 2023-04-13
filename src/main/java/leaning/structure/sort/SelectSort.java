package leaning.structure.sort;

import java.util.Arrays;

/**
 * 选择排序
 *  时间复杂度O(n²)
 * 1选择培训一共有数组大小-1轮排序
 * 2每一轮排序，又是一个循环，循环的规则代码
 * 2.1先假定当前这个数是小数
 * 2.2然后和后面每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
 * 2.3当遍历到数组的最后，就得到本轮最小数和下标
 * 2.4交换
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 0, 20,2,4,2,4};
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            int min=arr[i];
            //1先获取最小的
            for (int j=1+i;j<=arr.length-1;j++){
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
