package leaning.structure.linkedlist.test01;

public class SingleLinkedList {

    /**
     * 初始化一个头节点
     */
    HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode tmpNode = head;
        while (true) {
            if (tmpNode.nextNode == null) {
                break;
            }
            tmpNode = tmpNode.nextNode;
        }
        tmpNode.nextNode = heroNode;
    }
}
