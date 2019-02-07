package linkedList_noDummyHead;

import impl.ListNode;

/**
 * Reverse a singly linked list (recursive)
 * 
 * Examples:
 * L = null, return null
 * L = 1 -> null, return 1 -> null
 * L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 * 
 * Time: O(n), Space: O(n)
 */
public class ReverseLinkedListII {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverse(next);
		next.next = head;
		head.next = null;
		return newHead;
	}
}
