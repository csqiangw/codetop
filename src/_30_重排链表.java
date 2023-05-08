public class _30_重排链表 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //1.快慢指针找中点
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            if(fast == head){
                fast = fast.next.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        //2.后半段翻转
        ListNode headNode = new ListNode(0,null);
        ListNode p,q,r,u = null;
        while(head2 != null){
            q = head2.next;
            head2.next = headNode.next;
            headNode.next = head2;
            head2 = q;
        }
        head2 = headNode.next;
        //3.合并
        p = head;
        q = head2;
        while(p != null){
            r = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            u = q;
            q = r;
        }
        if(q != null){
            u.next = q;
        }
    }

}
