package leaning.structure.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5000); //添加5个小孩
        circleSingleLinkedList.showBoy();
   //测试小孩出圈
        circleSingleLinkedList.countBoy(1,20,5);

    }
}
