package DataStructUtils.LinkedList;


public class LinkedListUtils {
    public static void showList(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
    }

    public static void createList(ListNode head, int[] arr) {
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] arr = {1, 2, 3, 4};
        createList(head, arr);
        showList(head);
    }
}
