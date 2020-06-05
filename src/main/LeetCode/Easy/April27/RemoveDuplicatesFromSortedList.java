package main.LeetCode.Easy.April27;


import main.LeetCode.Easy.April27.MergeTwoSortedLists.ListNode;

public class RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode res=head;
    while(head!=null&&head.next!=null){
      if(head.val==head.next.val){
        head.next=head.next.next;
      }else
        head=head.next;
    }
    return res;
  }

}
