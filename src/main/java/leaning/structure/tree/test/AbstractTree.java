package leaning.structure.tree.test;

public abstract class AbstractTree {
    public abstract void add(Node node);

    public abstract void preList(Node node);

    public abstract void midList(Node node1);

    public void postList(Node node1) {
    }

    public abstract void preListOther(Node node1);
}
