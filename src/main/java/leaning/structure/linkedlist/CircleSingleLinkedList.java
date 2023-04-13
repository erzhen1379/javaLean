package leaning.structure.linkedlist;

/**
 * 创建一个环形的单向链表
 */
public class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;


    /**
     * 添加小孩节点，侯建成个环形的链表
     *
     * @param nums
     */
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针，帮助构建环形链表
        //使用for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);  //构成环
                curBoy = first;  //让curboy指向第一小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历
     */
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        //因为first 不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) { //说明已经遍历完成
                break;
            }
            curBoy = curBoy.getNext(); //curBoy后移
        }
    }


    /**
     * 根据用户的输入，计算小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初由多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，重新输入");
            return;
        }
        //要创建一个辅助指针，帮助完成一个小孩
        Boy helper = first;
        //需要创建一个辅助指针变量helper，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { //说明helper指向最后小孩
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //小孩报数前，先让first 和helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) {//说明圈中只有一个节点
                break;
            }
            //让first 和helper指针同时移动countnum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中小孩的编号%d \n",first.getNo());

    }


}
