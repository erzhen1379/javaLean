package leaning.structure.tree.test01;

public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node1 = new Node(1, "1宋江");
        Node node2 = new Node(2, "2吴用");
        Node node3 = new Node(3, "3卢俊义");
        Node node4 = new Node(4, "4林冲");
        Node node5 = new Node(5, "5关胜");
        Node node6 = new Node(6, "林冲6");
        Node node7 = new Node(7, "关胜7");

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        tree.setRoot(node1);
        //  System.out.println("----------非递归前序遍历--------------");
        //    tree.preListOther(node1);
        System.out.println("--------前序遍历-------");
        tree.preList(node1);
        System.out.println("--------中序遍历-------");
        tree.midList(node1);
        System.out.println("--------后序遍历------------");
        tree.postList(node1);
        System.out.println("---------前序查找------------------");
        int id = 7;
        Node node = null;
        node = tree.preSearchIndex(id);
        System.out.printf("前序查找结果 id=%d name=%s\n", node.id, node.name);
        node = tree.midSearchIndex(id);
        System.out.printf("中序查找结果 id=%d name=%s", node.id, node.name);

        //删除节点
        System.out.println("--------前序遍历-------");
        tree.preList(node1);
        System.out.println("--------删除节点--------");
        tree.delNode(id);
        tree.preList(node1);

    }
}
