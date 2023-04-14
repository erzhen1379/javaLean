package leaning.structure.linkedlist;

import java.util.Stack;

/**
 * 定义SingleLinkedList 管理我们的英雄
 */
public class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");
    //返回头节点

    /**
     * 返回头节点
     *
     * @return
     */
    public HeroNode getHead() {
        return head;
    }

    //添加到节点到单向链表
    //思路，当不考虑编号顺序时候
    //1,找到当前链表最后的节点
    //2j将最格欧这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历tmp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;

    }

    //

    /**
     * 第二种方式在添加英雄时候，根据排名将英雄添加到指定的位置
     * <p>
     * 如果有这个排名，则添加失败，并且给提示
     *
     * @param heroNode
     */
    public void addOrder(HeroNode heroNode) {
//因为头节点不能动，因此我们仍然需要一个辅助指针（变量）来找到需要添加的位置
        //因为是单链表，找到的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;   //flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {  //说明temp已经在最后的位置上了
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp后面添加
                break;
            } else if (temp.next.no == heroNode.no) { //说明新添加的节点已经存在
                flag = true;
                break;
            }
            temp = temp.next; //后移，遍历当前链表

        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 修改节点的信息，根据no编号来修改，即no编号不能改
     *
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;   //表示是否找到改节点
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     * 1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2.说明我们在比较死，是tem.next.no和需要删除的节点的no比较
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;  //标志是否找到待删除的节点
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) {
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }


    /**
     * 显示链表（遍历）
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }

    /**
     * 查到单链表中倒数第k个节点
     * 1编写一个方法，接收head节点，同时接收index
     * 2.index表示是倒数第index节点
     * 3.先把链表从头遍历到尾，得到链表的总长度
     * 4得到size，我们从链表中第一个开始遍历（size-index）
     * 5.如果找到，则返回改节点，否则就返回null
     *
     * @param head
     * @param index
     * @return
     */
    public HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表是否为空
        if (head.next == null) {
            return null;  //链表为空
        }
        //第一遍遍历改链表的长度（节点的个数）
        int size = getLength(head);
        //第二遍遍历size-index位置，就我我们倒数第k个节点
        //先进行index校验
        if (index <= 0 || index > index) {
            return null;
        }
        //定义一个辅助变量,for循环定位到倒数index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 将链表反转
     *
     * @param head
     */
    public void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助指针（变量），帮我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;  //指向当前节点[cur]下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，将其取出，放在新的节点下面
        while (cur != null) {
            next = cur.next;  //先暂时保存当前节点的下一个节点，因为后面需要用
            cur.next = reverseHead.next;  //将cur链接到新的链表中
            reverseHead.next = cur;
            cur = next; //让cur后移

        }
        //将head.next 指向reverseHead.next  实现链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 方式2：
     * 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
     *
     * @param head
     */
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            //将链表所有节点压入栈

            stack.push(cur);
            //   System.out.println("----"+cur);
            cur = cur.next;  //cur后移，这样就可以压入下一个节点
        }
        while (stack.size() > 0) {
            System.out.println("出栈--》" + stack.pop());
        }

    }

    /**
     * 获单链表头节点的个数（如果有头节点不统计头节点）
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public int getLength(HeroNode heroNode) {
        if (head.next == null) {  //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量，这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }


}
