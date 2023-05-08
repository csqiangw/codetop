import java.util.HashMap;
import java.util.Map;

public class _41_删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode newHead = new ListNode();
        ListNode p = head;
        while(p != null){
            map.put(p.val,map.getOrDefault(p.val,0) + 1);
            p = p.next;
        }
        p = newHead;
        while(head != null){
            if(map.get(head.val) == 1){
                p.next = head;
                p = head;
            }
            head = head.next;
        }
        return newHead.next;
    }

}
