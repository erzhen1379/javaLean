package leaning.structure.tree.test;

import leaning.structure.tree.HeroNode;

public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node1 = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");
        Node node6 = new Node(6, "林冲6");
        Node node7 = new Node(7, "关胜7");

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        tree.setRoot(node1);
        System.out.println("----------非递归前序遍历--------------");
        tree.preListOther(node1);
        System.out.println("--------前序遍历-------");
        tree.preList(node1);
        System.out.println("--------中序遍历-------");
        tree.midList(node1);
        System.out.println("--------后序遍历------------");
        tree.postList(node1);

    }
}
