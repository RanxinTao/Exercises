package fastSlowPointers;

import impl.ListNode;

/**
 * Check if a given linked list has a cycle. Return true if it does, otherwise return false.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class CheckIfLinkedListHasACycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
