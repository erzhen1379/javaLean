package leaning.structure.linkedlist.test004;

/**
 * 4.删除链表倒数第n个节点
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
        /*System.out.println("---------删除倒数第n个节点----------");
        listList.delLastNumNode(listList.head, 2);*/

        System.out.println("------通过1次遍历-----");
        Node head = listList.deleLastNumNode(listList.head, 2);
        listList.list(head);
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

    public void list(Node node) {
        Node currNode = node;
        while (true) {
            if (currNode.nextNode == null) {
                break;
            }
            currNode = currNode.nextNode;
            System.out.println(currNode.toString());
        }
    }

    /**
     * 方法一：通过2次遍历
     * 删除链表倒数第n个元素
     */
    public void delLastNumNode(Node node, int no) {
        Node currNode = node.nextNode;
        int count = 0;
        while (currNode != null) {
            count++;
            currNode = currNode.nextNode;
        }
        int delNum = count - no;
        System.out.println(delNum);
        Node tmpNode = node.nextNode;
        while (tmpNode != null) {
            if (tmpNode.nextNode.id == delNum) {
                tmpNode.nextNode = tmpNode.nextNode.nextNode;
                break;
            }
            tmpNode = tmpNode.nextNode;
        }
    }

    /**
     * 方法二(推荐)：通过1次遍历
     * 删除链表倒数第n个元素
     */
    public Node deleLastNumNode(Node node, int no) {
        Node fastNode = node.nextNode;
        Node slowNode = node.nextNode;
        //1.第一次先让fast先走n步
        for (int i = 0; i < no; i++) {
            fastNode = fastNode.nextNode;
        }
        //2.第二次fast走完剩下的步骤,注意此时是fastNode.nextNode后一个节点
        while (fastNode.nextNode != null) {
            fastNode = fastNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        //3.当前slowNode移动就是需要删除节点
        slowNode.nextNode = slowNode.nextNode.nextNode;
        return node;
    }
}
