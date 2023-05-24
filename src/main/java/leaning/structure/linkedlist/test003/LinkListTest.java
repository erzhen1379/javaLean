package leaning.structure.linkedlist.test003;

/**
 * 3.链表排序,todo 待完善
 */
public class LinkListTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江1");
        Node node2 = new Node(2, "宋江2");
        Node node3 = new Node(3, "宋江3");
        Node node4 = new Node(4, "宋江4");
        Node node5 = new Node(5, "宋江5");
        ListList listList = new ListList();
        listList.add(node5);
        listList.add(node4);
        listList.add(node2);
        listList.add(node3);
        listList.add(node1);
        System.out.println("遍历");
        listList.list();
        //   orderLinkList(listList);
        // listList.list();
        System.out.println("-----冒泡排序反转-------");
        bubbleSort(listList.head);
        listList.list();

    }

    /**
     * 对链表进行排序
     *
     * @param listList
     */
    private static void orderLinkList(ListList listList) {
        Node currNode = listList.head;
        while (true) {
            if (currNode.nextNode == null) {
                break;
            }
            Node currTmpNode = currNode;
            Node preNode = null;
            Node endNode = null;
            while (true) {
                if (currTmpNode == null) {
                    break;
                }
                //1.判断当前节点
                if (currTmpNode.id > currTmpNode.nextNode.id) {
                    //进行链表掉转
                    endNode = currTmpNode.nextNode;
                    currTmpNode.nextNode = preNode;
                    preNode = currTmpNode;
                }
                currTmpNode = currTmpNode.nextNode;
            }
            currNode = currNode.nextNode;
        }
        System.out.println("--------");
        listList.list();
    }

    //冒泡排序
    public static Node bubbleSort(Node head) {
        if (head == null || head.nextNode == null)  //链表为空或者仅有单个结点
            return head;

        Node cur = null;
        Node tail = null;

        cur = head;

        while (cur.nextNode != tail) {
            while (cur.nextNode != tail) {
                if (cur.id > cur.nextNode.id) {
                    int tmp = cur.id;
                    cur.id = cur.nextNode.id;

                    cur.nextNode.id = tmp;
                }
                cur = cur.nextNode;
            }

            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }

        return head;


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
