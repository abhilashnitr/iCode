package main.FAANG.TwoPointers;

public class LC142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)  return null;
        ListNode pointer1 = head.next;
        ListNode pointer2 = head.next.next;
        //Step 1
        while(pointer1!=pointer2){
            if(pointer2.next==null || pointer2.next.next==null)   return null;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        pointer1 = head;
        //Step 2
        while(pointer1!=pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }
}
