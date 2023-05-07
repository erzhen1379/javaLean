package leaning.jdk.myArraylist;

/**
 * 实现list方法
 */
public interface MyList<E> {
    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    void add(int index, E element);

    boolean add(E e);

    void list();
}
