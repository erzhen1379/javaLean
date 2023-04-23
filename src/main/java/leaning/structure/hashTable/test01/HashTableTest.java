package leaning.structure.hashTable.test01;

import leaning.structure.linkedlist.test01.HeroNode;

public class HashTableTest {
    public static void main(String[] args) {
        System.out.println("-----------测试hash表------------------");
        Node hero1 = new Node(1, "宋江");
        Node hero2 = new Node(2, "卢俊义");
        Node hero3 = new Node(3, "吴用");
        Node hero4 = new Node(4, "林冲");
        Node hero5 = new Node(9, "测试用户");
        System.out.println("--------add------------");
        HashTable hashTable = new HashTable(7);
        hashTable.add(hero1);
        hashTable.add(hero2);
        hashTable.add(hero3);
        hashTable.add(hero4);
        hashTable.add(hero5);
        System.out.println("---------list-------------------");
        hashTable.list();
        System.out.println("----------find-----------------");
        hashTable.find(3);
        System.out.println("------------update----------------------");
        hashTable.update(9, "测试用户修改");
        hashTable.list();
        System.out.println("----------delete----------------");
        hashTable.delete(9);
        hashTable.list();
    }
}
