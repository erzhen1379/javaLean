package leaning.structure.tree.test01;

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
            if (node.left != null) {
                preList(node.left);
            }
            if (node.right != null) {
                preList(node.right);
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
            midList(node.right);
        }
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
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
            postList(node.right);
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
                if (currNode.left == null) {
                    continue;
                }
                currNode = currNode.left;
                if (currNode.left == null) {
                    continue;
                }
            }
        }
    }

    /**
     * 前序查找
     *
     * @param id
     */
    @Override
    public Node preSearchIndex(int id) {
        if (root != null) {
            return root.preOrderSearchIndex(id);
        }
        return null;
    }

    public Node midSearchIndex(int id) {
        if (root != null) {
            return root.midOrderSearchIndex(id);
        }
        return null;
    }

    public void delNode(int id) {
        if (root != null) {
            if (root.id == id) {
                root = null;
            }
            root.delNode(id);
        }
    }
}
