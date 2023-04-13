package leaning.structure.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //需要创建二叉树
        BinaryTree binnaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //说明，我们先手动创建该二叉树，后续我们学习递归方法
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binnaryTree.setRoot(root);
        //测试
        System.out.println("前序遍历"); //1,2,3,5,4
        binnaryTree.preOrder();

        System.out.println("中序遍历"); //2,1,5,3,4
        binnaryTree.infixOrder();

        System.out.println("后序遍历"); // 2,5,4,3,1
        binnaryTree.postOrder();

        //前序查找
        System.out.println("前序遍历方式");
        HeroNode resNode = binnaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 5);
        }
        //中序查找
        System.out.println("中序遍历方式");
        HeroNode resNode2 = binnaryTree.infixOrderSearch(5);
        if (resNode2 != null) {
            System.out.printf("找到了，信息为 no=%d name=%s", resNode2.getNo(), resNode2.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 5);
        }

        //后序查找
        System.out.println("后序遍历方式");
        HeroNode resNode3 = binnaryTree.postOrderSearch(5);
        if (resNode3 != null) {
            System.out.printf("找到了，信息为 no=%d name=%s", resNode3.getNo(), resNode3.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 5);
        }
        //测试删除代码
        System.out.println("删除前，前序遍历");
        binnaryTree.preOrder();
        binnaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binnaryTree.preOrder();
    }
}
