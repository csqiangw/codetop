public class _2_两数相加 {

    //和字符串按位相加的逻辑是一样的
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retHead = new ListNode(),p = retHead,q;
        int n1,n2,carry = 0,sum;
        while(l1 != null || l2 != null){
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            sum = n1 + n2 + carry;
            q = new ListNode(sum == 10 ? 0 : sum % 10);
            carry = sum / 10;
            p.next = q;
            p = q;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry != 0){
            q = new ListNode(carry);
            p.next = q;
            p = q;
        }
        p.next = null;
        return retHead.next;
    }

}
