package leaning.structure.tree.test01;

/**
 * 定义一个node节点
 */
public class Node {
    int id;
    String name;
    Node left;
    Node right;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node() {
    }


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Node preOrderSearchIndex(int id) {
        if (this.id == id) {
            return this;
        }
        Node currNode = null;
        //todo 如果左侧不为空
        if (this.left != null) {
            currNode = this.left.preOrderSearchIndex(id);
        }
        //如果左侧不为null，说明找到了
        if (currNode != null) {
            return currNode;
        }
        if (this.right != null) {
            currNode = this.right.preOrderSearchIndex(id);
        }
        return currNode;
    }

    public Node midOrderSearchIndex(int id) {
        Node currNode = null;
        if (this.left != null) {
            currNode = this.left.midOrderSearchIndex(id);
        }
        if (currNode != null) {
            return currNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            currNode = this.right.preOrderSearchIndex(id);
        }
        return currNode;
    }

    /**
     * 删除节点
     * 1.判断是否是叶子节点
     *
     * @param id
     */
    public void delNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(id);
        }
        if (this.right != null) {
            this.right.delNode(id);
        }
    }
}
