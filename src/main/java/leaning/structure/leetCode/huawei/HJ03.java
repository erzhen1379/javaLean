package leaning.structure.leetCode.huawei;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * HJ3 明明的随机数
 * 描述
 * 明明生成了
 * �
 * N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * <p>
 * 数据范围：
 * 1
 * ≤
 * �
 * ≤
 * 1000
 * <p>
 * 1≤n≤1000  ，输入的数字大小满足
 * 1
 * ≤
 * �
 * �
 * �
 * ≤
 * 500
 * <p>
 * 1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 */
public class HJ03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            integers.add(scanner.nextInt());
        }
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
