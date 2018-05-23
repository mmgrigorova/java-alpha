package datastructures;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
//        1->2->3->4->5->NULL
        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);


        ListNode result = Solution.deleteDuplicates(head);
        print(result);
    }

    public static void print(ListNode x) {
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            ListNode result = head;

            if (head == null) {
                return head;
            }

            while (head.next != null){
                if(head.val == head.next.val){
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return result;
        }
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
