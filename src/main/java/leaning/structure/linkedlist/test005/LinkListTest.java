package leaning.structure.linkedlist.test005;

import java.util.HashSet;

/**
 * 删除链表中重复出现
 * 1 2 3 3 4 4 2 1 1   -> 1 2 3 4
 */
public class LinkListTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江1");
        Node node11 = new Node(1, "宋江1");
        Node node111 = new Node(1, "宋江1");
        Node node2 = new Node(2, "宋江2");
        Node node22 = new Node(2, "宋江2");
        Node node3 = new Node(3, "宋江3");
        Node node33 = new Node(3, "宋江3");
        Node node4 = new Node(4, "宋江4");
        Node node44 = new Node(4, "宋江4");
        Node node5 = new Node(5, "宋江5");
        ListList listList = new ListList();
        listList.add(node1);
        listList.add(node2);
        listList.add(node3);
        listList.add(node33);
        listList.add(node4);
        listList.add(node44);
        listList.add(node22);
        listList.add(node11);
        listList.add(node111);
        System.out.println("遍历");
        listList.list();
        System.out.println("---------删除重复出现的-----------");
        Node head = deleteDuplicates(listList.head);
        listList.list(head);
    }
/**
 * Node{id=1, name='宋江1'}
 * Node{id=2, name='宋江2'}
 * Node{id=3, name='宋江3'}
 * Node{id=3, name='宋江3'}
 * Node{id=4, name='宋江4'}
 * Node{id=4, name='宋江4'}
 * Node{id=2, name='宋江2'}
 * Node{id=1, name='宋江1'}
 * Node{id=1, name='宋江1'}
 */


    /**
     * 删除相同node
     */
    public static Node deleteDuplicates(Node head) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Node currNode = head.nextNode;
        Node pre = head;
        hashSet.add(head.id);
        while (currNode != null) {
            if (hashSet.contains(currNode.id)) {
                pre.nextNode = currNode.nextNode;
            } else {
                hashSet.add(currNode.id);
                pre = currNode;
            }
            currNode = currNode.nextNode;
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
}
