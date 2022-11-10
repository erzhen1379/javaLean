package leaning.jdk.jstacktool;

public class Math {
 
    public static final int initData = 666;
 
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }
 
    public static void main(String[] args) {
        Math math = new Math();
        while (true){
            math.compute(); //不停循环计算
        }
    }
}