package leaning.structure.test;

/**
 * 合并2个链表
 * 常规方法
 */
public class Test03 {
    public static void main(String[] args) {
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        Linklist linklist1 = new Linklist();
        linklist1.add(node11);
        linklist1.add(node12);

        Node node21 = new Node(21);
        Node node22 = new Node(22);

        Linklist linklist2 = new Linklist();
        linklist2.add(node21);
        linklist2.add(node22);

        mergeList(linklist1, linklist2);
        linklist1.list(linklist1);

    }

    public static Linklist mergeList(Linklist linklist1, Linklist linklist2) {
        System.out.println("-----合并2个链表,递归方法------------");
        if (linklist1 == null) {
            return linklist2;
        }
        if (linklist2 == null) {
            return linklist1;
        }
        return linklist1;
    }

    /**
     * 定义链表
     */
    class Linklist {
        Node head;

        public Linklist() {
            head = new Node();
        }

        public void add(Node node) {
            if (head == null) {
                head = node;
                return;
            }
            Node currNode = head;
            while (true) {
                if (currNode.next == null) {
                    currNode.next = node;
                    break;
                }
                currNode = currNode.next;
            }
        }

        public void list(Linklist linklist) {
            Node currNode = linklist.head;
            while (true) {
                if (currNode.next == null) {
                    break;

                }
                currNode = currNode.next;
                System.out.println(String.valueOf(currNode.id));

            }
        }
    }

    /**
     * 定义node节点
     */
    class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }

        public Node() {
        }
    }
}