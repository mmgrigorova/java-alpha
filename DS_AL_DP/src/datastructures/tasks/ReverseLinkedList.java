package datastructures.tasks;//https://leetcode.com/problems/reverse-linked-list/description/

public class ReverseLinkedList {

    public static void main(String[] args) {
//        1->2->3->4->5->NULL
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Solution.reverseList(head);
        print(result);
    }

    public static void print(ListNode x) {
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
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

    static class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            ListNode nextElem;

            while (current != null){
                nextElem = current.next;
                current.next = prev;
                prev = current;
                current = nextElem;
            }

           return prev;
        }
    }

}
