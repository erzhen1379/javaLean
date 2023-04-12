package leaning.jdk.abstractDemo;

/**
 * 不同几何图形的面积计算公式是不同的，但是它们具有的特性是相同的，都具有长和宽这两个属性，
 * 也都具有面积计算的方法。那么可以定义一个抽象类，在该抽象类中含有两个属性（width 和 height）
 * 和一个抽象方法 area( )，具体步骤如下。
 */
public abstract class Shape {
    public int width; //宽
    public int height;//高

    public Shape(int width, int hight) {
        this.width = width;
        this.height = hight;
    }

    /**
     * 被abstract 修饰的方法，子类必须要重写
     *
     * @return
     */
    public abstract double area();  //定义一个抽象方法，计算面积

    /**
     * 普通方法，子类可以不重写
     *
     * @param width
     * @param height
     * @return
     */
    public double leng() {
        System.out.println("开始计算周长");
        return 0;
    }


}
