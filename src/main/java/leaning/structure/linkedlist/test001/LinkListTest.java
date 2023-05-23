package leaning.structure.linkedlist.test001;

/**
 * 合同2个链表
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
        System.out.println("修改");
        listList.update(4, "宋江44");
        listList.list();
        // System.out.println("删除");
        //listList.delete(1);
        //listList.list();

        Node node11 = new Node(6, "宋江6");
        Node node21 = new Node(7, "宋江7");
        Node node31 = new Node(8, "宋江8");
        Node node41 = new Node(9, "宋江9");
        Node node51 = new Node(10, "宋江10");
        ListList listList1 = new ListList();
        listList1.add(node11);
        listList1.add(node21);
        listList1.add(node31);
        listList1.add(node41);
        listList1.add(node51);
        System.out.println("遍历");
        listList1.list();
        listList.list();
        System.out.println("-----合并数组--------");
        ListList merge = merge(listList, listList1);
        merge.list();
    }

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

    public void update(int id, String name) {
        Node currNode = head;
        while (true) {
            if (currNode.nextNode.id == id) {
                currNode.nextNode.name = name;
                break;
            }
            currNode = currNode.nextNode;
        }
    }

    public void delete(int id) {
        Node currNode = head;
        while (true) {
            if (currNode.nextNode.id == id) {
                if (currNode.nextNode.nextNode == null) {
                    currNode.nextNode = null;
                    break;
                }
                currNode.nextNode = currNode.nextNode.nextNode;
                break;
            }
            currNode = currNode.nextNode;
        }
    }
}