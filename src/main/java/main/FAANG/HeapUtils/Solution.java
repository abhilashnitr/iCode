package main.FAANG.HeapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }
        //[[1,4,5],[1,3,4],[2,6]]

        Node list1 = new Node(1);
        list1.next=new Node(4);
        list1.next.next=new Node(5);

        Node list2 = new Node(1);
        list2.next=new Node(3);
        list2.next.next=new Node(4);

        Node list3 = new Node(2);
        list3.next=new Node(6);

        List<Node> lists=new ArrayList<Node>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        Node ans=mergeKList(lists);
        System.out.println(ans.val);
        printNodes(ans);

        //list2.next.next=new Node(4);
    }




    public static Node mergeKList(List<Node> lists){

        int k=lists.size();
        if(k==0)
            return null;


        PriorityQueue<Node> minHeap=new PriorityQueue<>();

        for(Node node:lists){
            if(node!=null)
                minHeap.offer(node);
        }

        Node ans=new Node(0);
        Node ansCopy=ans;
        while(!minHeap.isEmpty()){
            Node temp=minHeap.poll();
            ans.next=temp;
            ans=ans.next;
            if(temp.next!=null)
                minHeap.offer(temp.next);
        }

        return ansCopy.next;
    }

    public static void printNodes(Node node){

        while(node!=null){
            System.out.print(node.val +" ");
            node = node.next;
        }

    }



}

class Node implements Comparable<Node>{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }

    @Override
    public int compareTo(Node a){
        return this.val-a.val;
    }

}


//
// Your previous JavaScript content is preserved below:
//  Node is not abstract and does not override abstract method compareTo(Object) in Comparable
// // You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
// // Merge all the linked-lists into one sorted linked-list and return it.
//
// // Constraints:
// // k == lists.length
// // 0 <= k <= 10^4
// // 0 <= lists[i].length <= 500
// // -10^4 <= lists[i][j] <= 10^4
// // lists[i] is sorted in ascending order.
// // The sum of lists[i].length won't exceed 10^4
//
// // Example 1:
// // Input: lists = [[1,4,5],[1,3,4],[2,6]]  k  n  O(nlogk)
// // Output: [1,1,2,3,4,4,5,6]
// // Explanation: The linked-lists are:
// // [
// //   1->4->5,
// //   1->3->4,
// //   2->6
// // ]
// // merging them into one sorted list:
// // 1->1->2->3->4->4->5->6
//
//
// // Example 2:
// // Input: lists = []
// // Output: []
//
//
// // Example 3:
// // Input: lists = [[]]
// // Output: []
//
//
//




// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]

// Input: root = [2,1,1]
// Output: [[1]]

// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]



/*

              1
        2            3
    4              2    4
                4


*/






