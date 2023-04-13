package leaning.structure.linkedlist;

/**
 * 测试单链表
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
/*        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);*/

        singleLinkedList.addOrder(hero1);
        singleLinkedList.addOrder(hero3);
        singleLinkedList.addOrder(hero2);
        singleLinkedList.addOrder(hero4);

        //测试修改节点代码
     /*   HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟修改");
        singleLinkedList.update(newHeroNode);*/

        //测地删除节点
    //    singleLinkedList.delete(2);
//测试一下 求单链表中有效节点的个数
        System.out.println("有效的节点个数=" + singleLinkedList.getLength(singleLinkedList.getHead()));//2

/*        //测试一下看看是否得到了倒数第K个节点
        HeroNode res = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println("res=" + res);*/

        singleLinkedList.list();
  /*      System.out.println("--------反转单链表------------");
        singleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();*/
        System.out.println("--------测试栈反转列表---------");
        singleLinkedList.reversePrint(singleLinkedList.getHead());




    }


}
