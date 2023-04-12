package leaning.jdk.abstractDemo;

/**
 * 定义一个三角形类，该类与正方形类一样，需要继承形状类 Shape，并重写父类中的抽象方法 area()
 */
public class Triangle extends Shape {
    public Triangle(int width, int height) {
        super(width, height);

    }

    // 重写父类中的抽象方法，实现计算三角形面积的功能
    @Override
    public double area() {
        return 0.5 * width * height;
    }
}
