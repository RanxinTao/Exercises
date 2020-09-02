package fastSlowPointers;

import impl.ListNode;

/**
 * Find the middle node of a given linked list.
 * 
 * Examples:
 * 1. L = null, return null
 * 2. L = 1 -> null, return 1
 * 3. L = 1 -> 2 -> null, return 1
 * 4. L = 1 -> 2 -> 3 -> null, return 2
 * 5. L = 1 -> 2 -> 3 -> 4 -> null, return 2
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class MiddleNodeOfLinkedList {
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
