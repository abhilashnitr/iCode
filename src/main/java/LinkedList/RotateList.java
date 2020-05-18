package LinkedList;

public class RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    int len=0;
    ListNode curr=head,tail=null;

    while(curr!=null){
      if(curr.next==null)
        tail=curr;
      len++;
      curr=curr.next;
    }

    if(len <=1) return head;

    k=k%len;

    // no need for rotation
    if(k==0) return head;

    int var=len-k;

    curr=head;
    // for finding the kth-1 node from end.
    while(--var > 0)
      curr=curr.next;

    tail.next=head;
    head=curr.next;
    curr.next=null;


    return head;
  }

}
