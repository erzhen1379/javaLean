package leaning.structure.leetCode;

/**
 * 搜索插入位置
 */
public class Demo35a {


    public static int getMax(int[] array) {
        int max = 0, temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp += array[i];
            if (temp < 0)
                temp = 0;
            if (max < temp)
                max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array1 = {-1, -3, -2, -4, -5};
        int[] array2 = {1, -3, -2, 4, 5};
        System.out.println(getMax(array1));
        System.out.println(getMax(array2));
    }

}
