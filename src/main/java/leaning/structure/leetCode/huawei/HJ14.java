package leaning.structure.leetCode.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 字符串排序
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            //注意此时是next，不然会出现少一个字符
            treeSet.add(sc.next());
        }
        for (String value : treeSet) {
            System.out.println(value);

        }
    }
}
