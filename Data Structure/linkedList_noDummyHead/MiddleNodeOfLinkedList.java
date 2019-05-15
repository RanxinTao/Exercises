package linkedList_noDummyHead;

import impl.ListNode;

/**
 * Find the middle node of a given linked list.
 * 
 * Examples:
 * L = null, return null
 * L = 1 -> null, return 1
 * L = 1 -> 2 -> null, return 1
 * L = 1 -> 2 -> 3 -> null, return 2
 * L = 1 -> 2 -> 3 -> 4 -> null, return 2
 * 
 * Algorithm: fast-slow pointer
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
