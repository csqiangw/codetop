public class _34_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pPointer = head;
        while(n-- > 0)
            pPointer = pPointer.next;
        ListNode nPointer = head,pre = null;
        while(pPointer != null){
            pre = nPointer;
            pPointer = pPointer.next;
            nPointer = nPointer.next;
        }
        if(pre == null){
            head = nPointer.next;
            nPointer.next = null;
        }else{
            pre.next = nPointer.next;
            nPointer.next = null;
        }
        return head;
    }

}
