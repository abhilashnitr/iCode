package LeetCode.Easy.April27;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode head= new ListNode(0);
    ListNode tail=head;

    while(true){
      if(l1 == null)
      {
        tail.next = l2;
        break;
      }
      if(l2 == null)
      {
        tail.next = l1;
        break;
      }
      if(l1.val<=l2.val){
        tail.next=l1;
        l1=l1.next;
      }
      else {
        tail.next=l2;
        l2=l2.next;
      }
      tail = tail.next;
    }
    return head.next;

  }
  public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;


    if (l1.val < l2.val) {
      l1.next = mergeTwoLists2(l1.next, l2);
      return l1;
    }
    else {
      l2.next = mergeTwoLists2(l1, l2.next);
      return l2;
    }
  }
}
