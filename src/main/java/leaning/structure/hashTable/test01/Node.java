package leaning.structure.hashTable.test01;

/**
 * 定义hash表node节点
 */
public class Node {
    int id;
    String name;
    Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
