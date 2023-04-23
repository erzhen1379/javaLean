package leaning.structure.hashTable.test01;


/**
 * 定义hash 表
 */
public class HashTable {
    LinkedListTable[] linkedListTables;
    int size;

    /**
     * 有参数构造
     *
     * @param size
     */
    public HashTable(int size) {
        this.size = size;
        //1.定义一个size的数组
        linkedListTables = new LinkedListTable[size];
        //2.创建size条数组
        for (int i = 0; i < size; i++) {
            linkedListTables[i] = new LinkedListTable();
        }
    }


    /**
     * 哈希表添加元素
     *
     * @param node
     */
    public void add(Node node) {
        //1.获取当前node所在链表位置
        int idLocation = funHash(node.id);
        //2.将当前节点加入到对应链表最后
        linkedListTables[idLocation].add(node);
    }

    /**
     * 返回链表位置信息
     *
     * @param id
     */
    private int funHash(int id) {
        return id % size;
    }

    /**
     * 遍历hash表
     */
    public void list() {
        //1.遍历数组
        for (int i = 0; i < size; i++) {
            linkedListTables[i].list(i);
        }
    }

    /**
     * 更新
     *
     * @param id
     * @param name
     */
    public void update(int id, String name) {
        int idLocation = funHash(id);
        linkedListTables[idLocation].update(id, name);
    }

    public void delete(int id) {
        int idLocation = funHash(id);
        linkedListTables[idLocation].delete(id);
    }

    public void find(int id) {
        int idLocation = funHash(id);
        linkedListTables[idLocation].find(id);
    }
}
