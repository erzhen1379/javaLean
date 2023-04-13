package effective.github.ch2;

/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        NutritionFacts coclCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).builder();
        System.out.println(coclCola.toString());
    }
}
