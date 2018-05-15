import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // 1->2->4, 1->3->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = Solution.mergeTwoLists(l1, l2);
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
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode node = new ListNode(-1);
            ListNode result = node;

            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                node = node.next;
            }

            while(l1 != null){
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node = node.next;
            }

            while(l2 != null){
                node.next = new ListNode(l2.val);
                l2 = l2.next;
                node = node.next;
            }


            return result.next;
        }
    }
}
