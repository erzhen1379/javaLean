package leaning.structure.leetCode.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 */
public class HJ08 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            if (map.containsKey(key)) {
                Integer tmp = map.get(key);
                map.put(key, value + tmp);
            } else {
                map.put(key, value);
            }
        }
        for (Integer key : map.keySet()) {
            System.out.println( key + " " + map.get(key));
        }

    }
}
