package leaning.structure.hashTable.test01;

/**
 * 定义链表
 */
public class LinkedListTable {
    Node head;

    public LinkedListTable() {
        this.head = new Node(0, "");
    }

    /**
     * 添加node节点
     *
     * @param node
     */
    public void add(Node node) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.next == null) {
                currNode.next = node;
                break;
            }
            currNode = currNode.next;
        }
    }

    public void list(int id) {
        Node currNode = head;
        if (currNode == null) {
            System.out.println("当前链表为null");
        }
        System.out.println("当前链表：" + (id + 1));
        while (currNode != null) {
            if (currNode.next == null) {
                break;
            }
            currNode = currNode.next;
            System.out.println(currNode.toString());
        }
    }

    public void update(int id, String name) {
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            if (currNode.id == id) {
                currNode.name = name;
                break;
            }
        }
    }

    public void delete(int id) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.next != null) {
                if (currNode.next.id == id) {
                    currNode.next = currNode.next.next;
                }
            }
            currNode = currNode.next;
        }
    }

    public void find(int id) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.id == id) {
                System.out.println(currNode.toString());
            }
            currNode = currNode.next;
        }
    }
}
