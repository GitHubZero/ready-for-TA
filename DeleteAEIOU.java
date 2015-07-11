public class DeleteAEIOU {
    public ListNode delete(ListNode p) {
        if (p == null) {
            return p;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = p;
        ListNode pre = dummy;
        pre.next = cur;
        while (cur != null) {
            if (cur.val == 1 || cur.val == 3 || cur.val == 5) {
                cur = cur.next;
            }else{
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args){
        //chage it to delete 1 3 5 7;
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        DeleteAEIOU test = new DeleteAEIOU();
        ListNode res = test.delete(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}