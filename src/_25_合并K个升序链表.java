public class _25_合并K个升序链表 {

    public ListNode head = new ListNode();

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        ListNode merge = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            merge = mergeTwoLists(merge,lists[i]);
        }
        head.next = null;
        return merge;
    }

}
