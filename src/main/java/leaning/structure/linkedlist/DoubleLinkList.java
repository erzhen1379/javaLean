package leaning.structure.linkedlist;

/**
 * 创建一个双向链表的类
 */
public class DoubleLinkList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }
//遍历双向链表的一个方法

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
        HeroNode2 temp = head.next;
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

    //添加到节点到单向链表
    //思路，当不考虑编号顺序时候
    //1,找到当前链表最后的节点

    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历tmp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;

    }

    /**
     * 修改节点的信息，根据no编号来修改，即no编号不能改
     * 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
     * 只是 节点类型改成 HeroNode2
     *
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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
     * 从双向链表中删除一个节点,
     * 说明
     * 1 对于双向链表，我们可以直接找到要删除的这个节点
     * 2 找到后，自我删除即可
     *
     * @param no
     */
    public void del(int no) {
        //判断当前链表 是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;  //标志是否找到待删除的节点
        while (true) {
            if (temp == null) { //已经到链表的最后
                break;
            }
            if (temp.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) {
            //可以删除
           // temp.next = temp.next.next;
            temp.pre.next=temp.next;
            //如果是最后一个节点，我们不需要执行下面，否则报空指针异常
            if (temp.next==null){
                temp.next.pre=temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }


}
