package main.FAANG.HeapUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

    //Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
    //
    //The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
    //There are NN nodes in the final linked list.
    //Space complexity :
    //
    //O(n)O(n) Creating a new linked list costs O(n)O(n) space.
    //O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).


    public static void main(String[] args) {
        List<ListNode> lists= new ArrayList<>();
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(3);
        node1.next.next.next=new ListNode(5);

        ListNode node2=new ListNode(4);
        node2.next=new ListNode(6);
        node2.next.next=new ListNode(8);

        ListNode node3=new ListNode(7);
        node3.next=new ListNode(8);
        node3.next.next=new ListNode(10);

        lists.add(node1);
        lists.add(node2);
        lists.add(node3);

        MergeKLists mergeKLists=new MergeKLists();
        ListNode ans=mergeKLists.mergeKLists(lists);

        while(ans!=null){
            System.out.print(ans.val+" ");
            ans=ans.next;
        }

    }
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

//        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(), (o1, o2) -> {
//            if (o1.val<o2.val)
//                return -1;
//            else if (o1.val==o2.val)
//                return 0;
//            else
//                return 1;
//        });

        //minHeap
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(), (o1, o2) -> o1.val-o2.val);

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    //using merge sort
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
