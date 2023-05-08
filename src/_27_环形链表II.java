/**
 * 推导原理：
 * 假设slow 与 fast相遇时，slow距离head为k，那么fast速度时slow的两倍，围绕交汇点跑一圈也是k（2k - k）
 * 假设入口点距离交汇点长度为m，那么head距离入口点就为k - m，而此时交汇点绕一圈到入口点也是k - m
 * 所以随便置slow或fast为head，再同时向后走，直到相等就是交汇点
 */
public class _27_环形链表II {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)//防止就一个节点的情形
            return null;//链表无环
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
