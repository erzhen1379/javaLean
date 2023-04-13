package leaning.structure.leetCode;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 求数组中两个数之和等于第三个数
 */
public class Sum01 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 5, 2, 5, 2};
        int target = 4;
        Map<Integer, Integer> map = twoSum(arr, target);
        //获得迭代器
        Iterator<Integer> iterator = map.keySet().iterator();
//遍历迭代器
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + "-->" + map.get(key));

        }
    }


    public static Map<Integer, Integer> twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (target == arr[i] + arr[j]) {
                    System.out.println("第一个数为" + i + " 第二个数为" + j);
                    map.put(i, j);
                }
            }
        }
        if (map.isEmpty()) {
            throw new IllegalArgumentException("没找到");
        }
        return map;
    }

}
