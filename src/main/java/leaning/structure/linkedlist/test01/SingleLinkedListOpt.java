package leaning.structure.linkedlist.test01;

public class SingleLinkedListOpt {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        System.out.println("-----------list------------");
        //遍历链表
        singleLinkedList.list();
        System.out.println("----------find------------");
        //根据名字查询别名
        HeroNode heroNode = singleLinkedList.findNiceName("宋江");
        System.out.println(heroNode.nickname);
        System.out.println("--------update-----------");
        //修改别名
        singleLinkedList.updateNickName(3, "吴用", "修改吴用智多星别名");
        singleLinkedList.list();
        System.out.println("------------delete-----------------");
        singleLinkedList.deleteNode(3);
        singleLinkedList.list();
    }
}
