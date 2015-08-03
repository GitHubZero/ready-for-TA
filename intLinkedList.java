/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class intLinkedList {
    public ListNode convert (int n) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (n != 0) {
            ListNode newItem = new ListNode(n % 10);
            cur.next = newItem;
            cur = cur.next;
            n /= 10;
        }
        //reverse
        cur = dummy.next;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        int n = 123;
        intLinkedList test = new intLinkedList();
        ListNode res = test.convert(n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}