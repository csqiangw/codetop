import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 往优先级队列插入，然后再一个一个弹出，这样会省时间
 * 还可以考虑归并排序，就是每次双指针分割就行
 * 或者直接借助数组，然后sort
 */
public class _43_排序链表 {

    public ListNode sortList(ListNode head) {
        Queue<Integer> pQueue = new PriorityQueue<Integer>((o1,o2) -> {return o1 - o2;});
        ListNode p = head;
        while(p != null){
            pQueue.offer(p.val);
            p = p.next;
        }
        p = head;
        while(!pQueue.isEmpty()){
            p.val = pQueue.poll();
            p = p.next;
        }
        return head;
    }

}
