package main.LinkedList;


  // Data Structure to store a linked list node
  class Node {
    int data;
    Node next;

    // Constructor
    Node(int i)
    {
      this.data = i;
      this.next = null;
    }
  };

  class CheckPallindrome
  {
    // Function to split nodes of the given linked list into two halves using the
    // fast/slow pointer strategy. It returns pointer to the tail of first half
    public static Node FrontBackSplit(Node head)
    {
      Node slow = head;
      Node fast = head.next;

      // Advance 'fast' by two nodes, and advance 'slow' by single node
      while (fast != null)
      {
        fast = fast.next;
        if (fast != null)
        {
          slow = slow.next;
          fast = fast.next;
        }
      }

      return slow;
    }

    // Reverses the given linked list by changing its .next pointers and
    // its head pointer.
    public static Node reverse(Node head)
    {
      Node prev = null;		// the prev pointer
      Node current = head;		// the main pointer

      // traverse the list
      while (current != null)
      {
        // tricky: note the next node
        Node next = current.next;

        current.next = prev;	// fix the current node

        // advance the two pointers
        prev = current;
        current = next;
      }

      // fix the head pointer to point to the new front
      head = prev;
      return head;
    }

    // Function to determine if a given linked list is palindrome or not
    public static boolean isPalindrome(Node head)
    {
      // if length is less than 2, handle separately
      if (head == null || head.next == null) {
        return true;
      }

      Node a = head, b, aTail, bHead;

      // split the linked list into two halves
      // If number of nodes are odd, the extra node will go in the first list
      aTail = FrontBackSplit(head);

      // 'aTail' is before the midpoint in the list, so split it in two
      // at that point.
      b = aTail.next;
      aTail.next = null;

      // reverse second half
      b = reverse(b);
      bHead = b;

      // traverse both lists simultaneously and compare their data
      while (a != null && b != null)
      {
        // return false at first data mismatch
        if (a.data != b.data) {
          return false;
        }

        // advance both lists to the next nodes
        a = a.next;
        b = b.next;
      }

      // restore second half
      bHead = reverse(bHead);

      // restore original linked list before returning by
      // linking the first half with the second half
      aTail.next = bHead;

      // we reach here only when the linked list is palindrome
      return true;
    }

    public static void main(String[] args)
    {
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(1);
      head.next.next.next.next = new Node(1);

      if (isPalindrome(head)) {
        System.out.print("Linked list is Palindrome");
      } else {
        System.out.print("Linked list is not Palindrome");
      }
    }
  }


