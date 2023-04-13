package leaning.structure.hashTable;

/**
 * 创建EmpLinkedList ,表示链表
 */
public class EmpLinkedList {
    //头指针，执行第一个emp，因此我想这个链表的head是可以指向第一个tmp
    private Emp head;  //默认为null

    //添加雇员到链表
    //说明
    //1假定，当添加雇员时候，id是自增长，即id的分配总是从小到大
    //因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用第一个辅助指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (head.next == null) {//说明到链表最后
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {//说明该链表为空
            System.out.println("第 " + (no + 1) + "链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Emp curEmp = head;   //辅助指针
        while (true) {
            System.out.printf("=> id%d name=\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;  //后移遍历
        }
        System.out.println();
    }

    /**
     * 根据id查找雇员
     * 如果查到到，就返回emp，如果没有找到就返回null
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head==null){
            System.out.println("该链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp=head;
        while (true){
            if (curEmp.id==id){//找到
                break;  //这时候curEmp就指向要查找的雇员
            }
            //退出
            if (curEmp.next==null){//说明遍历当前链表没有找到该雇员
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;//以后
        }
        return curEmp;
    }
}
