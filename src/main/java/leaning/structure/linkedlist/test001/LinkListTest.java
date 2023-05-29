package leaning.structure.linkedlist.test001;

/**
 * 1.合并2个2链表
 * 2.合并2个有序链表
 */
public class LinkListTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江1");
        Node node2 = new Node(2, "宋江2");
        Node node3 = new Node(3, "宋江3");
        Node node4 = new Node(4, "宋江4");
        Node node5 = new Node(5, "宋江5");
        Node node6 = new Node(6, "宋江6");
        Node node7 = new Node(7, "宋江7");
        Node node8 = new Node(8, "宋江8");
        Node node9 = new Node(9, "宋江9");
        Node node10 = new Node(10, "宋江10");
        ListList listList1 = new ListList();
        listList1.add(node1);
        listList1.add(node3);
        listList1.add(node5);
        listList1.add(node7);
        listList1.add(node9);
        System.out.println("遍历");

        ListList listList2 = new ListList();
        listList2.add(node2);
        listList2.add(node4);
        listList2.add(node6);
        listList2.add(node8);
        listList2.add(node10);
        System.out.println("遍历");
        listList1.list();
        listList2.list();
        System.out.println("合并2个有序链表");
        Node node = mergeTwoLists(listList1.head.nextNode, listList2.head.nextNode);
        while (node != null) {
            System.out.println(node.toString());
            node = node.nextNode;
        }
    }

    /**
     * 合并2个链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListList merge(ListList list1, ListList list2) {
        Node currNode1 = list1.head;
        while (true) {
            if (currNode1.nextNode == null) {
                list1.add(list2.head.nextNode);
                break;
            }
            currNode1 = currNode1.nextNode;
        }
        return list1;
    }

    /**
     * 合并2个有序链表
     *前提：2个链表是有序的
     * @return
     */
    public static Node mergeTwoLists(Node node1, Node node2) {
        //1.判断是否为null
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        //2.确定当前node节点下一个节点
        if (node1.id < node2.id) {
            node1.nextNode = mergeTwoLists(node1.nextNode, node2);
            return node1;
        } else {
            node2.nextNode = mergeTwoLists(node1, node2.nextNode);
            return node2;
        }
    }
}


class Node {
    int id;
    String name;
    Node nextNode;

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

class ListList {
    Node head;

    public ListList() {
        this.head = new Node(0, "");
    }

    public void add(Node node) {
        Node currNode = head;
        while (true) {
            if (currNode.nextNode == null) {
                currNode.nextNode = node;
                break;
            }
            currNode = currNode.nextNode;
        }
    }

    public void list() {
        Node currNode = head;
        while (true) {
            if (currNode.nextNode == null) {
                break;
            }
            currNode = currNode.nextNode;
            System.out.println(currNode.toString());
        }
    }
}