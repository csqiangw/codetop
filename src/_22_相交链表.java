public class _22_相交链表 {

    public int getLength(ListNode l){
        int length = 0;
        while(l != null){
            length++;
            l = l.next;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int al = getLength(headA),bl = getLength(headB);
        while(al != bl){
            if(al > bl){
                headA = headA.next;
                al--;
            }else{
                headB = headB.next;
                bl--;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

}
