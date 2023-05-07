package leaning.jdk.myArraylist;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Object> myArrayList = new MyArrayList<>();

        myArrayList.add(0, 3);
        myArrayList.add(1, 1);
        myArrayList.add(2, 5);
        myArrayList.add(3, 9);
        myArrayList.add(4, 2);
        myArrayList.add(5, 3);
        myArrayList.list();

    }
}
