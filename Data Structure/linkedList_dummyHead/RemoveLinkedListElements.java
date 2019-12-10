package linkedList_dummyHead;

import impl.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Examples:
 * Given: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6  Return: 1 -> 2 -> 3 -> 4 -> 5 
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		pre.next = head;
		while (pre.next != null) {
			if (pre.next.value == val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}
		return dummy.next;
	}
}
