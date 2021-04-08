package main.LeetCodePractise;

public class AddTwoNumbers {


    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;

        int carry = 0;
        ListNode curr= result;

        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;

    }
}




/*
You are given two non-empty linked lists representing two non-negative integers. The digits
are stored in reverse order, and each of their nodes contains a single digit. Add the two
numbers and return the sum as a linked list.You may assume the two numbers do not contain
any leading zero, except the number 0 itself
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
* */