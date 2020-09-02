package fastSlowPointers;

import impl.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head. If n is not 
 * valid, you do not need to do anything to the original list.
 * Try to do this in one pass.
 * 
 * Examples:
 * 1. Given linked list: 1->2->3->4->5, and n = 2. After removing the second node from the end, the
 * linked list becomes 1->2->3->5.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		while (fast.next != null && n > 0) {
			fast = fast.next;
			n--;
		}
		if (n != 0) {
			return dummy.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		} // now slow is the node right before the target node
		slow.next = slow.next.next;
		return dummy.next;
	}
}
