package linkedList_noDummyHead;

import impl.ListNode;

/**
 * Reverse a singly linked list (iterative)
 * 
 * Examples:
 * L = null, return null
 * L = 1 -> null, return 1 -> null
 * L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseLinkedListI {
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
