package main.LinkedList;



public class ReverseList {

  public static void main(String[] args) {
    ListNode head=new ListNode(1);
    head.next=new ListNode(2);
    head.next.next=new ListNode(3);
    head.next.next.next=new ListNode(4);
       head.next.next.next.next=new ListNode(5);
    head.next.next.next.next.next=new ListNode(6);
    //head.next.next.next.next.next.next=head.next.next.next;
    ListNode re=reverseBetween2(head,2,4);
    //ListNode re=reverse(head,4);
    //ListNode re=deleteDuplicates(head);
    //ListNode re=deleteval(head,6);
    printList(re);

    //System.out.println(detectLoop(head));
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


  public static ListNode reverseBetween2(ListNode head, int m, int n) {
    if(head == null) return null;
    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
    dummy.next = head;
    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
    for(int i = 0; i<m-1; i++) pre = pre.next;

    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
    ListNode then = start.next; // a pointer to a node that will be reversed

    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5

    for(int i=0; i<n-m; i++)
    {
      start.next = then.next;
      then.next = pre.next;
      pre.next = then;
      then = start.next;
    }

    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
    return dummy.next;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pointer = dummy;
    while (pointer != null) {
      ListNode node = pointer;
      // first check whether there are k nodes to reverse
      for (int i = 0; i < k && node != null; i++) {
        node = node.next;
      }
      if (node == null) break;

      // now we know that we have k nodes, we will start from the first node
      ListNode prev = null, curr = pointer.next, next = null;
      for (int i = 0; i < k; i++) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      ListNode tail = pointer.next;
      tail.next = curr;
      pointer.next = prev;
      pointer = tail;
    }
    return dummy.next;
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
