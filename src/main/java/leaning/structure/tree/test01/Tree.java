package leaning.structure.tree.test;

public class Tree extends AbstractTree {
    Node root;

    @Override
    public void add(Node node) {

    }

    /**
     * 前序遍历
     *
     * @param node
     */
    @Override
    public void preList(Node node) {
        System.out.println(node.toString());
        if (node != null) {
            if (node.getLeft() != null) {
                preList(node.getLeft());
            }
            if (node.getRight() != null) {
                preList(node.getRight());
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node1
     */
    @Override
    public void midList(Node node) {
        if (node != null) {
            midList(node.left);
            System.out.println(node.toString());
            midList(node.getRight());
        }
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    /**
     * 后序遍历
     *
     * @param node1
     */
    public void postList(Node node) {
        if (node != null) {
            postList(node.left);
            System.out.println(node.toString());
            postList(node.getRight());
        }
    }

    /**
     * 非递归前序遍历
     *
     * @param node
     */
    public void preListOther(Node node) {
        Node currNode = node;
        while (true) {
            if (currNode != null) {
                System.out.println(currNode.toString());
                if (currNode.getLeft() == null) {
                    continue;
                }
                currNode = currNode.getLeft();
                if (currNode.getRight() == null) {
                    continue;
                }
            }
        }
    }
}
