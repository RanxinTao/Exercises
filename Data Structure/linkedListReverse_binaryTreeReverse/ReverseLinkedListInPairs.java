package linkedListReverse_binaryTreeReverse;

import impl.ListNode;

/**
 * Examples: 
 * L = null, after reverse is null
 * L = 1 -> null, after reverse is 1 -> null
 * L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
 * L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 */
public class ReverseLinkedListInPairs {
	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;
			first.next = null;
			head = second.next;
			pre.next = second;
			pre = pre.next;
			pre.next = first;
			pre = pre.next;
		}
		pre.next = head;
		return dummy.next;
	}
}
