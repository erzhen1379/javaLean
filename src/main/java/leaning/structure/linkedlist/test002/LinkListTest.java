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
        System.out.println("-----反转-------");

          Node preNode = reLinkList(listList);
        listList.list(preNode);
        reverseList(listList.head);
    }

    /**
     * 方法一：遍历
     * 连，调，接，移
     *
     * @param listList
     */
    public static Node reLinkList(ListList listList) {
        //定义3个变量
        Node currNode = listList.head;
        Node preNode = null;
        Node endNode = null;
        while (true) {
            if (currNode == null) {
                break;
            }
            //1.需要保存当前链表的前一个节点
            endNode = currNode.nextNode;
            //2.赋予头结点
            currNode.nextNode = preNode;
            //3.将pre节点往后移动
            preNode = currNode;
            //4将curr 往后移动
            currNode = endNode;

        }
        return preNode;
    }

    /**
     * 通过递归
     *
     * @param
     * @return
     */
    public static Node reverseList(Node node) {
        return node;
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


    public void list(Node currNode) {
        while (true) {
            if (currNode.nextNode == null) {
                break;
            }
            System.out.println(currNode.toString());
            currNode = currNode.nextNode;
        }
    }
}