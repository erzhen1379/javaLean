package effective.github.ch3;

/**
 * public final filed实现singleton
 */
public class Elvis {
    //私有构造器仅仅被调研一次，用来实例化有的静态final域
    //缺少共有的或者受保护的构造器，保证Elvis唯一
    public static final Elvis INSTANCE = new Elvis();

    //保持构造器私有
    private Elvis() {
    }

    public void leaveTheNuilding() {
    }
}
