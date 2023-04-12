package leaning.jdk.abstractDemo;

public class ShapeTest {
    public static void main(String[] args) {
        Square square = new Square(5, 4);
        System.out.println("方形面积为：" + square.area());
        System.out.println("方形周长为：" + square.leng());
        Triangle triangle = new Triangle(5, 4);
        System.out.println("三角形面积为：" + triangle.area());

    }
}
