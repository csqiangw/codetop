public class _5_K个一组翻转链表 {

    /**
     * 正常的反转链表逻辑，但是更改结束条件，因为现在给的是一个连起的链表，所以，无法判断head为空，通过给定的k来计数判断
     * @param head
     * @param k
     * @param cnt
     * @return
     */
    public ListNode reverseList(ListNode head,int k,int cnt) {
        if(cnt == k){
            return head;
        }
        ListNode newNode = reverseList(head.next,k,cnt + 1);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    /**
     * 扭转k个节点后，把后面的部分当作一个整体，认为反转后给定翻转后的头，因为我局部处理就返回反转后的头
     * 其次，注意，出口是当向后寻找下一个部分扭转的头时，若为空，则直接return头即可，不必再进行反转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nHead = head;
        int cnt = 0;
        while(cnt < k){
            if(nHead == null){
                return head;
            }
            nHead = nHead.next;
            cnt++;
        }
        ListNode newNode = reverseList(head, k, 1);
        head.next = reverseKGroup(nHead,k);
        return newNode;
    }

}
