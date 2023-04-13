package leaning.structure.leetCode;

/**
 * 合并两个链表
 */
public class Demo21 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        while (true) {
            System.out.println(listNode.next);
            if (listNode.next==null){
                break;
            }
            listNode=listNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;

        }
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}