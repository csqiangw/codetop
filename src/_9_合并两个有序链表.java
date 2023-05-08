public class _9_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode h = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                h.next = list1;
                h = list1;
                list1 = list1.next;
            }else{
                h.next = list2;
                h = list2;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            h.next = list1;
            h = list1;
            list1 = list1.next;
        }
        while(list2 != null){
            h.next = list2;
            h = list2;
            list2 = list2.next;
        }
        h.next = null;
        return head.next;
    }

}
