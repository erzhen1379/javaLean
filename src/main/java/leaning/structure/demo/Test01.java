package leaning.structure.demo;

/**
 * 反正字符串
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("11111111");
        String str = "adfsdf";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(str.length() - i-1);
            System.out.println(c);


        }
    }
}
