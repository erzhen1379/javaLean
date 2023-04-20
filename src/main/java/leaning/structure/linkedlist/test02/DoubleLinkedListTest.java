package leaning.structure.linkedlist.test02;


public class DoubleLinkedListTest {
    public static void main(String[] args) {

        Node2 hero1 = new Node2(1, "宋江", "及时雨");
        Node2 hero2 = new Node2(2, "卢俊义", "玉麒麟");
        Node2 hero3 = new Node2(3, "吴用", "智多星");
        Node2 hero4 = new Node2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("--------开始添加node-----------");
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        System.out.println("----------遍历node--------------------");
        doubleLinkedList.list();

        System.out.println("-----------更新链表----------------------------");
        doubleLinkedList.update(3, "吴用:外号更新");
        doubleLinkedList.list();
        System.out.println("----------删除链表节点----------------------------");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();
    }
}
