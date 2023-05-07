package leaning.jdk.myArraylist;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 定义一个arraylist方法
 */
public class MyArrayList<E> implements MyList<E> {
    E[] data;
    //指定数组初始化长度
    private static final int DEFAULT_CAPACITY = 10;
    //记录数组当中的有效长度
    public int size;

    /**
     * 创建一个构造函数
     *
     * @param
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("参数不合法异常:" + capacity);
        }
        data = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }


    /**
     * 无参构造
     */
    public MyArrayList() {
        this.data = (E[]) (new Object[DEFAULT_CAPACITY]);
        this.size = 0;
    }


    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        for (int i = 1; i <= 11; i++) {
            if (i == 11) {
                System.out.println("-----------");
            }
            arrayList.add(i);

        }
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        MyArrayList<Object> myArrayList = new MyArrayList<>();
    }


    @Override
    public void add(int index, E element) {


        //判断index 是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("下表异常：" + index);
        }
        //判断是否需要扩容
        if (size + 1 == data.length) {
            resize((size * 3) / 2 + 1);
        }
        data[index] = element;
        size++;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j + 1] != null) {
                    if (Integer.parseInt(data[j].toString()) > Integer.parseInt(data[j + 1].toString())) {
                        E tmp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = tmp;
                    }
                }
            }
        }

    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public void list() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(i + " : " + data[i]);
            }
        }
    }

    /**
     * 对数组重新扩容长度
     *
     * @return
     */
    public void resize(int length) {
        //创建一个新的数组
        E[] newData = (E[]) (new Object[length]);
        //将老的数组拷贝到新的数组中
        for (int i = 0; i < data.length; i++) {
            //将老的数组放到新的数组中
            newData[i] = data[i];
        }
        //将新数组给到data
        data = newData;
    }

}
