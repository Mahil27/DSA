// Problem: Linked List Cycle
// LeetCode: 141
// Pattern: Fast and Slow Pointers (Floyd’s Cycle Detection)
// Approach:
// Use two pointers moving at different speeds.
// If a cycle exists, they will meet.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
// Definition for singly-linked list.
//class ListNode {
//    int val;
//  ListNode next;
//  ListNode(int x) {
//      val = x;
//      next = null;
//  }
//}