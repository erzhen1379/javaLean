package leaning.structure.linkedlist.test02;

/**
 * 实现双链表
 */
public class Node2 {
    int id;
    String name;
    String nickName;
    Node2 pre;
    Node2 next;

    public Node2(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
