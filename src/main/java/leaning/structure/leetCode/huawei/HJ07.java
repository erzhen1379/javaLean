package leaning.structure.leetCode.huawei;

/**
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 */
public class HJ07 {
    public static void main(String[] args) {
        double d=7.1+0.5;
        System.out.println((int)d);
    }
}
