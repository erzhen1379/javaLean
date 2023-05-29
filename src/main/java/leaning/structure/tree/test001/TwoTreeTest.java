package leaning.structure.tree.test001;

/**
 * 01.测试二叉树常规遍历
 */
public class TwoTreeTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, "上海1");
        Node node2 = new Node(2, "上海2");
        Node node3 = new Node(3, "上海3");
        Node node4 = new Node(4, "上海4");
        Node node5 = new Node(5, "上海5");
        Node node6 = new Node(6, "上海6");
        Node node7 = new Node(7, "上海7");

        BinaryTree twoTree = new BinaryTree();
        twoTree.root = node1;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        System.out.println("------前序遍历--------");
        twoTree.preList(node1);
        System.out.println("------中序遍历--------");
        twoTree.midList(node1);
        System.out.println("------后序遍历--------");
        twoTree.postList(node1);

    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
    }

    /**
     * 1.前序 遍历
     *
     * @param node
     */
    public void preList(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.toString());
        preList(node.left);
        preList(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void midList(Node node) {
        if (node == null) {
            return;
        }
        midList(node.left);
        System.out.println(node.toString());
        midList(node.right);
    }

    public void postList(Node node) {
        if (node == null) {
            return;
        }
        postList(node.left);
        postList(node.right);
        System.out.println(node.toString());
    }
}

class Node {
    int id;
    String name;
    Node left;
    Node right;

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
