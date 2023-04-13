package leaning.structure.linkedlist;

/**
 * 创建一个boy类，表示一个节点
 */
public class Boy {
    private int no; //编号
    private Boy next; //指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
