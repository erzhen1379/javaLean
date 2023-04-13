package leaning.structure.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test(3000);
        System.out.println(factorial(6));
    }

    /**
     * 打印问题
     * @param n
     */
    public static void test(int n) {
        if (n > 2) {
            test(n -1);
        }
            System.out.println("n=" + n);

    }

    /**
     * 阶乘问题
     * @param n
     * @return
     */
   public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
   }
}
