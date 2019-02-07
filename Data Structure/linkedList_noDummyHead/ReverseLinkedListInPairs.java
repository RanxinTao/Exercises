package linkedList_noDummyHead;

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
		ListNode cur = dummy;
		while (head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;
			// move head pointer to the head of the next pair
			head = second.next;
			// add the second node
			cur.next = second;
			cur = cur.next;
			// add the first node
			cur.next = first;
			cur = cur.next;
		}
		// link the remaining possible nodes
		cur.next = head;
		return dummy.next;
	}
}
