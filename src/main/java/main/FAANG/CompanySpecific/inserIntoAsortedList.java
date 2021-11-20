package main.FAANG.CompanySpecific;

public class inserIntoAsortedList {
    //1) Linked List is empty:
    //    a)  since new_node is the only node in CLL, make a self loop.
    //          new_node->next = new_node;
    //    b) change the head pointer to point to new node.
    //          *head_ref = new_node;
    //2) New node is to be inserted just before the head node:
    //  (a) Find out the last node using a loop.
    //         while(current->next != *head_ref)
    //            current = current->next;
    //  (b) Change the next of last node.
    //         current->next = new_node;
    //  (c) Change next of new node to point to head.
    //         new_node->next = *head_ref;
    //  (d) change the head pointer to point to new node.
    //         *head_ref = new_node;
    //3) New node is to be  inserted somewhere after the head:
    //   (a) Locate the node after which new node is to be inserted.
    //         while ( current->next!= *head_ref &&
    //             current->next->data data)
    //         {   current = current->next;   }
    //   (b) Make next of new_node as next of the located pointer
    //         new_node->next = current->next;
    //   (c) Change the next of the located pointer
    //         current->next = new_node;

    static ListNode head;

    // Constructor
    inserIntoAsortedList()   { head = null; }

    static void sortedInsert(ListNode new_node)
    {
        ListNode current = head;
        // Case 1 of the above algo
        if (current == null)
        {
            new_node.next = new_node;
            head = new_node;
        }
        // Case 2 of the above algo
        else if (current.val >= new_node.val)
        {
                /* If value is smaller than head's value then
                 we need to change next of last node */
            while (current.next != head)
                current = current.next;
            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        // Case 3 of the above algo
        else
        {
            /* Locate the node before the point of insertion */
            while (current.next != head &&
                    current.next.val < new_node.val)
                current = current.next;
            new_node.next = current.next;
            current.next = new_node;
        }
    }

    static void printList()
    {
        if (head != null)
        {
            ListNode temp = head;
            do
            {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }  while (temp != head);
        }
    }

    public static void main(String[] args)
    {

        // Creating the linkedlist
        int arr[] = new int[] {12, 56, 2, 11, 1, 90};

        /* start with empty linked list */
        ListNode temp = null;

        /* Create linked list from the array arr[].
         Created linked list will be 1->2->11->12->56->90*/
        for (int i = 0; i < 6; i++)
        {
            temp = new ListNode(arr[i]);
            sortedInsert(temp);
        }

        printList();
    }


}
