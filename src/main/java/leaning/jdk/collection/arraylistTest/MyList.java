package leaning.jdk.collection.arraylistTest;

/**
 * 定一线程结构一些算法
 *
 * @param <E>
 */
public interface MyList<E> extends Iterable {
    /**
     * 末尾添加元素
     *
     * @param element
     */
    public void add(E element);

    /**
     * 按照指定下标添加
     *
     * @param index
     * @param element
     */
    public void add(int index, E element);

    /**
     * 按照指定下边删除元素
     *
     * @param index
     */
    public E remove(int index);

    /**
     * 获取指定下标元素
     * @param index
     */
    public E get(int index);

    /**
     * 修改指定下标的元素
     * @param index
     */
    public E set(int index);

}
