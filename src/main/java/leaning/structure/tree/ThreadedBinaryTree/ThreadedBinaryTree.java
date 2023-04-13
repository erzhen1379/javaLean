package leaning.structure.tree.ThreadedBinaryTree;


//定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;
    //为了实现线索化，需要创建要给指向当前结点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载一把threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环找到leftType==1的节点，第一个找到就是8节点
            //后面随着遍历的变化，因为当leftType==1时，说明该节点就是按照线索化
            //处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后续节点，就一直输出
            while (node.getLeftType() == 1) {
                //获取当前节点的后节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();
        }
    }

    //编写对二叉树进行中序线索化的方法

    /**
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {
        //如果node==null,不能线索化
        if (node == null) {
            return;
        }
        //1先线索化左子树
        threadedNodes(node.getLeft());
        //2线索化当前节点
        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }
        //处理后续节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向 当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setLeftType(1);
        }
        //每处理一个节点后，让当前节点是下个节点的前驱节点
        pre = node;
        //3线索化右子树
        threadedNodes(node.getRight());

    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}