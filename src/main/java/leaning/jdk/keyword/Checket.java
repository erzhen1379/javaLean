package leaning.jdk.keyword;

class Base {
    Base() {
        System.out.println("Base");
    }
}


public class Checket extends Base {
    Checket() {
        super();
        System.out.println("Checket");
    }

    public static void main(String argv[]) {
        Checket a = new Checket();
    }
}