package effective.github.ch3;

/**
 * static factory 实现songleton
 */
public class Elvis1 {
    private static final Elvis1 INSTANCE = new Elvis1();

    private Elvis1() {
    }

    /**
     * 调用Elvis1.getInstance都会返回同一个对象，不会新创建一个实例
     *
     * @return
     */
    public static Elvis1 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }
}
