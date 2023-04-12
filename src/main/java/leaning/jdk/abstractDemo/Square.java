package leaning.jdk.abstractDemo;

/**
 * 定义一个正方形类，该类继承自形状类 Shape，并重写了 area( ) 抽象方法。正方形类的代码如下：
 */
public class Square extends Shape {
    public Square(int wight, int height) {
        super(wight, height);
    }

    // 重写父类中的抽象方法，实现计算正方形面积的功能
    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double leng() {
        return 2 * (width + height);
    }
}
