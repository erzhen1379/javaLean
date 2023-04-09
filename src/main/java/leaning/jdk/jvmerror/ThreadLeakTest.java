package leaning.jdk.jvmerror;

/**
 *
 */
public class ThreadLeakTest {

    public static void main(String[] args) {
        while (true) {
            new ForeverThread().start();
        }
    }

}

