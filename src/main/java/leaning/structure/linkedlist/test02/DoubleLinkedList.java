package leaning.structure.linkedlist.test02;

public class DoubleLinkedList {
    //初始化一个头结点，不放置任何数据
    Node2 head = new Node2(0, "", "");

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node2 node) {
        Node2 currNode = head;
        while (true) {
            if (currNode.next == null) {
                break;
            }
            currNode = currNode.next;
        }
        currNode.next = node;
        node.pre = currNode;
    }

    public void list() {
        Node2 currNode = head;
        while (true) {
            if (currNode.next == null) {
                break;
            }
            currNode = currNode.next;
            System.out.println(currNode.toString());
        }
    }

    public void update(int id, String nickName) {
        Node2 currNode = head;
        while (true) {
            if (currNode.next.id == id) {
                currNode.next.nickName = nickName;
                break;
            }
            currNode = currNode.next;
        }
    }

    public void delete(int id) {
        Node2 currNode = head;
        while (true) {
            if (currNode.next.id == id) {
                currNode = currNode.next.next;
                currNode.pre = currNode.pre.pre;
                break;
            }
        }
    }
}
