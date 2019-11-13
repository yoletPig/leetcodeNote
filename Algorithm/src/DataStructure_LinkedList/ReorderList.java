package DataStructure_LinkedList;

import DataStructUtils.LinkedList.ListNode;

import static DataStructUtils.LinkedList.LinkedListUtils.createList;
import static DataStructUtils.LinkedList.LinkedListUtils.showList;


public class ReorderList {
    public void reorderList(ListNode head) {
        int len = 0, count = 1;
        ListNode temp = head;
        ListNode p = head.next;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        if (len>4){
            while (count <= len/2 ) {
                temp = p;
                if (p.next.next==null)
                {
                    break;
                }
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                ListNode lastNode = temp.next;
                lastNode.next = p.next;
                p.next = lastNode;
                temp.next = null;
                p = p.next.next;
                count += 1;
            }
        }
        if (len==4||len==3){
            temp = p;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            ListNode lastNode = temp.next;
            lastNode.next = p.next;
            p.next = lastNode;
            temp.next = null;
        }
    }

//--------------------------------
    //1ms
    public void reorderList1(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //find middle of the list
        ListNode p1=head, p2=head;
        while(p2.next!=null && p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        //reverse the right half
        ListNode n1=p1,n2=p1.next;;
        while(n2.next!=null){
            ListNode c=n2.next;
            n2.next=c.next;
            c.next=n1.next;
            n1.next=c;
        }
        //merge left and right
        ListNode s=head,t=p1.next;;
        while(s!=p1){
            p1.next=t.next;
            t.next=s.next;
            s.next=t;
            s=t.next;
            t=p1.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] arr = {1,2,3,4,5,6,7};
        createList(head, arr);
        showList(head);
        ReorderList r = new ReorderList();
        r.reorderList1(head);
        showList(head);
    }
}


