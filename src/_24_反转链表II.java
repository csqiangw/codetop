public class _24_反转链表II {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public ListNode reverseBetween(ListNode head, int left, int right){
       ListNode newHead = new ListNode();
       newHead.next = head;
       ListNode pre = newHead,p =head,mid = null,l_pre = null,r_next = null;
       int cnt = 1;
       while(true){
           if(left == cnt){
               mid = p;
               l_pre = pre;
               pre.next = null;
           }
           if(right == cnt){
               r_next = p.next;
               p.next = null;
               break;
           }
           cnt++;
           pre = p;
           p = p.next;
       }
       mid = reverseList(mid);
       p = mid;
       while(p.next != null)
           p = p.next;
       l_pre.next = mid;
       p.next = r_next;
       return newHead.next;
    }

}
