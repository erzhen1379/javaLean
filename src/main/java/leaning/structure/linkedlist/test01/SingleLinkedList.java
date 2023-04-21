package leaning.structure.linkedlist.test01;

public class SingleLinkedList {

    /**
     * 初始化一个头节点
     */
    HeroNode head = new HeroNode(0, "", "");

    /**
     * 遍历链表
     */
    public void list() {
        HeroNode tmpNode = head;
        while (true) {
            if (tmpNode.nextNode == null) {
                break;
            }
            tmpNode = tmpNode.nextNode;
            System.out.println(tmpNode.toString());
        }
    }

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

    public HeroNode findNiceName(String name) {
        HeroNode tmpNode = head;
        while (true) {
            if (tmpNode.nextNode == null) {
                break;
            }
            tmpNode = tmpNode.nextNode;
            if (tmpNode.name.equals(name)) {
                return tmpNode;
            }
        }
        return null;
    }

    public void updateNickName(int id, String name, String nickName) {
        HeroNode tmpNode = head;
        while (true) {
            if (tmpNode.nextNode == null) {
                break;
            }
            tmpNode = tmpNode.nextNode;
            if (tmpNode.id == id) {
                tmpNode.nickname = nickName;
            }
        }
    }

    public void deleteNode(int id) {
        HeroNode tmpNode = head;
        boolean flag = false;
        while (true) {
            if (tmpNode.nextNode == null) {
                break;
            }
            tmpNode = tmpNode.nextNode;
            if (tmpNode.id == id) {
                flag = true;
                break;
            }
            if (flag) {
                tmpNode.nextNode= tmpNode.nextNode.nextNode;

            }
        }
    }
}
