package fastSlowPointers;

import impl.ListNode;

/**
 * Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if
 * there is no cycle.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class CycleNodeInLinkedList {
	public ListNode cycleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
