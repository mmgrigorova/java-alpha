import java.util.List;
import java.util.Stack;

public class RotateList {
    public static void main(String[] args) {
//        1->2->3->4->5->NULL
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        int k = 4;

        ListNode result = Solution.rotateRight(head, k);
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
        public static ListNode rotateRight(ListNode head, int k) {
            ListNode node = head;
            ListNode tail = head;

            if (head == null || node.next == null || k == 0) {
                return head;
            }

            int size = 1;

            while (tail.next != null) {
                size += 1;
                tail = tail.next;
            }

            k = size - (k % size);

            for (int i = 1; i < k; i++) {
                node = node.next;
            }

            tail.next = head;
            head = node.next;
            node.next = null;

            return head;
        }
    }
}
