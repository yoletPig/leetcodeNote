package DataStructure_LinkedList;

import DataStructUtils.LinkedList.ListNode;

public class middleNode {
    public ListNode middleNode(ListNode head) {
        /**
         * 快慢指针求链表中间的结点。
         */
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next.next!= null){
            fast = fast.next.next;
            slow =slow.next;
        }
        if (fast.next.next == null){
            slow = slow.next;
        }
        return slow;
    }
}
