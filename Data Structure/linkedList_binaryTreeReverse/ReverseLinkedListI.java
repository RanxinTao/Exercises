package linkedList_binaryTreeReverse;

import impl.ListNode;

/**
 * Reverse a singly linked list (iterative)
 * 
 * Time: O(n), Space: O(1)
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
