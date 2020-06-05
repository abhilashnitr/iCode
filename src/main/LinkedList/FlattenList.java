package main.LinkedList;

class Node1 {
  int data;
  Node1 next;
  Node1 down;
};

public class FlattenList {
  // Helper function to insert new node in the beginning of the
  // vertical linked list
  public static Node1 push(Node1 head,  int data)
  {
    Node1 newNode = new Node1();

    newNode.data = data;
    newNode.next = null;
    newNode.down = head;

    return newNode;
  }

  // Takes two lists sorted in increasing order, and merge their nodes
  // together to make one big sorted list which is returned
  public static Node1 SortedMerge(Node1 a, Node1 b)
  {
    if (a == null) {
      return b;
    }
    else if (b == null) {
      return a;
    }

    Node1 result;

    // Pick either a or b, and recur
    if (a.data <= b.data)
    {
      result = a;
      result.down = SortedMerge(a.down, b);
    }
    else
    {
      result = b;
      result.down = SortedMerge(a, b.down);
    }

    return result;
  }

	/*
		Split the nodes of the given list into front and back halves.
		If the length is odd, the extra node should go in the front list.
		It uses the fast/slow reference strategy
	*/

  public static Node1[] FrontBackSplit(Node1 source)
  {
    // if length is less than 2, handle separately
    if (source == null || source.down == null) {
      return new Node1[]{ source, null } ;
    }

    Node1 slow = source;
    Node1 fast = source.down;

    // Advance 'fast' two nodes, and advance 'slow' one node
    while (fast != null)
    {
      fast = fast.down;
      if (fast != null)
      {
        slow = slow.down;
        fast = fast.down;
      }
    }

    // 'slow' is before the midpoint in the list, so split it in two
    // at that point.
    Node1[] arr = new Node1[]{ source, slow.down };
    slow.down = null;

    return arr;
  }

 static Node1 flatten(Node1 root)
  {
    // Base Cases
    if (root == null || root.next == null)
      return root;

    // recur for list on right
    root.next = flatten(root.next);

    // now merge
    root = SortedMerge(root, root.next);

    // return the root
    // it will be in turn merged with its left
    return root;
  }

//  // Sort given linked list using Merge sort algorithm
//  public static Node1 MergeSort(Node1 head)
//  {
//    // Base case -- length 0 or 1
//    if (head == null || head.down == null) {
//      return head;
//    }
//
//    // Split head into 'a' and 'b' sublists
//    Node1[] arr = FrontBackSplit(head);
//    Node1 front = arr[0];
//    Node1 back = arr[1];
//
//    // Recursively sort the sublists
// //   front = MergeSort(front);
//  //  back = MergeSort(back);
//
//    // answer = merge the two sorted lists together
//    return SortedMerge(front, back);
//  }
//
  // Helper function to print given linked list
  public static void printList(Node1 head)
  {
    Node1 ptr = head;
    while (ptr != null)
    {
      System.out.print(ptr.data + " -> ");
      ptr = ptr.down;
    }

    System.out.println("null");
  }
//
//  // Iterative function to flatten and sort a given list
//  public static void flatten (Node1 head)
//  {
//    Node1 curr = head;
//
//    while (curr != null)
//    {
//      Node1 temp = curr;
//      while (temp.down != null) {
//        temp = temp.down;
//      }
//      temp.down = curr.next;
//      curr = curr.next;
//    }
//  }

  // Helper function to create a linked list with elements of given vector
  public static Node1 createVerticalList(Node1 head, int[] arr)
  {
    for (int key: arr) {
      head = push(head, key);
    }
    return head;
  }

  public static void main(String[] args)
  {
    Node1 head = null;

    int arr1[] = { 8, 6, 4, 1 };
    int arr2[] = { 7, 3, 2 };
    int arr3[] = { 9, 5 };
    int arr4[] = { 12, 11, 10 };

    head = createVerticalList(head, arr1);
    head.next = createVerticalList(head.next, arr2);
    head.next.next = createVerticalList(head.next.next, arr3);
    head.next.next.next = createVerticalList(head.next.next.next, arr4);
    printList(head);
    // flatten the list
    flatten(head);
    printList(head);
    //sort the list


    // print the flattened & sorted linked list
  //  printList(head);
  }
}
