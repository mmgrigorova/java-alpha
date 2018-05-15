import java.util.List;

public class RotateList {
    public static void main(String[] args) {
//        1->2->3->4->5->NULL
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Solution.rotateRight(head, 2);
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
            ListNode current = head;
            ListNode tempStart = head;

            if (head == null){
                return head;
            }

            while(current.next != null){
                current = current.next;
            }

            tempStart = current;
            tempStart.next = head;
            current.next = null;

            return tempStart;
        }
    }
}
