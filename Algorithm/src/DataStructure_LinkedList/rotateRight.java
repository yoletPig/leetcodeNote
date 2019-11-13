package DataStructure_LinkedList;

import DataStructUtils.LinkedList.LinkedListUtils;
import DataStructUtils.LinkedList.ListNode;

import java.util.LinkedList;

public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        //1 获取链表的长度
        int len = 0;
        ListNode curNode = head;
        ListNode lastNode = null;
        while (curNode != null){
            lastNode = curNode;
            curNode = curNode.next;
            len++;
        }
        if (k==0||len == 0||k%len==0){
            return head;
        }
        // k % len 实际移动的位数
        k%=len;

        int i = 1;
        ListNode curHead ;
        curNode = head;
        while (curNode != null){
            if (i==(len-k)){
                curHead = curNode.next;
                curNode.next = null;
                lastNode.next = head;
                head = curHead;
                break;
            }
            curNode = curNode.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        rotateRight rt = new rotateRight();
        int[] arr = {};
        ListNode head = new ListNode(1);
        LinkedListUtils.createList(head,arr);
        ListNode listNode = rt.rotateRight(head, 1);
        LinkedListUtils.showList(listNode);
    }
}
