package linkedListReverse_binaryTreeReverse;

import impl.ListNode;

/**
 * Reverse a singly linked list (recursive)
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
