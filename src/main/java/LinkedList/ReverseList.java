package LinkedList;



public class ReverseList {

  public static void main(String[] args) {
    ListNode head=new ListNode(1);
    head.next=new ListNode(2);
    head.next.next=new ListNode(3);
    head.next.next.next=new ListNode(4);
       head.next.next.next.next=new ListNode(5);
    head.next.next.next.next.next=new ListNode(6);
    //head.next.next.next.next.next.next=head.next.next.next;
    ListNode re=reverseBetween(head,2,4);
    //ListNode re=reverse(head,2);
    //ListNode re=deleteDuplicates(head);
    //ListNode re=deleteval(head,6);
    printList(re);

    System.out.println(detectLoop(head));
  }

  static boolean detectLoop(ListNode head)
  {
    ListNode slow_p = head, fast_p = head;
    while (slow_p != null && fast_p != null && fast_p.next != null) {
      slow_p = slow_p.next;
      fast_p = fast_p.next.next;
      if (slow_p == fast_p) {
        System.out.println("Found loop");
        return true;
      }
    }
    return false;
  }

  private static ListNode reverse(ListNode node) {
      ListNode newH = null;
      while (node != null) {
        ListNode next = node.next;
        node.next = newH;
        newH = node;
        node = next;
      }
      return newH;
  }

  public static ListNode deleteval(ListNode head,int val) {
    ListNode res=head;
    while(head.next!=null){
      if(head.next.val==val){
        head.next=head.next.next;
      }else
        head=head.next;
    }
    return res;
  }

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode res=head;
    while(head.next!=null){
      if(head.val==head.next.val){
        head.next=head.next.next;
      }else
      head=head.next;
    }
    return res;
  }


  private static void printList(ListNode re) {
    while (re!=null){
      System.out.print(re.val+" ");
      re=re.next;
    }

  }

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (head==null || head.next==null){
      return head;
    }

    ListNode preHead=new ListNode(0);
    preHead.next=head;

    ListNode pre=preHead;
    ListNode current=head;
    ListNode end=head;
    int countM=0;
    int countN=0;
    // find M point and N point
    while (countM<m || countN<n ){
      if (countM<m){
        pre=pre.next;
        current=current.next;
        countM++;
      }
      if (countN<n){
        end=end.next;
        countN++;
      }
    }

    // reverse from M point to N Point
    reverse(pre, end.next);
    return preHead.next;
  }

  private static void reverse(ListNode pre, ListNode endNext){
    ListNode cur=pre.next;
    while (cur.next!=endNext){
      ListNode next=cur.next;
      ListNode temp=pre.next;
      pre.next=cur.next;
      cur.next=cur.next.next;
      next.next=temp;
    }
  }

  static ListNode reverse(ListNode head, int k)
  {
    ListNode current = head;
    ListNode next = null;
    ListNode prev = null;

    int count = 0;

    /* Reverse first k nodes of linked list */
    while (count < k && current != null)
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
    if (next != null)
      head.next = reverse(next, k);

    // prev is now head of input list
    return prev;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
