package leaning.structure.linkedlist.test002;

/**
 * 2.翻转链表
 */
public class LinkListTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江1");
        Node node2 = new Node(2, "宋江2");
        Node node3 = new Node(3, "宋江3");
        Node node4 = new Node(4, "宋江4");
        Node node5 = new Node(5, "宋江5");
        ListList listList = new ListList();
        listList.add(node1);
        listList.add(node2);
        listList.add(node3);
        listList.add(node4);
        listList.add(node5);
        System.out.println("遍历");
        listList.list();
        listList.reLinkList(listList);
        System.out.println(String.valueOf(7 / 2));
    }

    /**
     * 翻转
     *
     * @param listList
     */
    public static void reLinkList(ListList listList) {


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

    public static void reLinkList(ListList listList) {

        Node currNode = listList.head;
     /*   while (true){

        }*/
    }
}