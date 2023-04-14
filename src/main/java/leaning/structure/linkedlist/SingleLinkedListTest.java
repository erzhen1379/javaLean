package leaning.structure.linkedlist;

/**
 * 测试单链表
 * <p>
 * <p>
 * 定义HeroNode类，定义节点属性；
 * 定义节点管理类SingleLinkedList，管理HeroNode
 * 添加节点到单向链表add，当不考虑编号顺序时，找到当前链表的最后节点，将最后节点的next指向新节点；
 * 添加节点到单向链表addByOrder,根据编号，将新节点添加到指定位置，需要辅助变量temp查找添加的位置，temp指位于添加位置的前一个节点
 * 更新节点信息update，传入节点的编号，找到需要修改的节点
 * 删除节点delete，辅助变量表示待删除节点的前一个节点，比较temp.next.no与要删除节点的编号
 * 显示链表list，遍历链表
 * <p>
 * ————————————————
 * 版权声明：本文为CSDN博主「minus_yao」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/money_yao/article/details/99408241
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //1.创建要给的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //2.加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        /**
         * 加入并且排序
         */
        singleLinkedList.addOrder(hero1);
        singleLinkedList.addOrder(hero3);
        singleLinkedList.addOrder(hero2);
        singleLinkedList.addOrder(hero4);

        //3.测试修改节点代码
     /*   HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟修改");
        singleLinkedList.update(newHeroNode);*/

        //4.测地删除节点
        //    singleLinkedList.delete(2);
//测试一下 求单链表中有效节点的个数
        System.out.println("有效的节点个数=" + singleLinkedList.getLength(singleLinkedList.getHead()));//2

/*        //5.测试一下看看是否得到了倒数第K个节点
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
