package linkedList_dummyHead;

import impl.ListNode;

/**
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> ... -> Nn -> null
 * to be N1 -> Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> ... -> null
 * 
 * Examples:
 * L = null, is reordered to null
 * L = 1 -> null, is reordered to 1 -> null
 * L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
 * L = 1 -> 2 -> 3 -> null, is reordered to 1 -> 3 -> 2 -> null
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ReOrderLinkedList {
	public ListNode reorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 1. find the middle node.
		ListNode mid = middleNode(head);
		ListNode one = head;
		ListNode two = mid.next;
		// de-link the second half from the list.
		mid.next = null;
		// 2. reverse the second half.
		two = reverse(two);
		// 3. merge the two halves.
		return merge(one, two);
	}
	
	private ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			cur.next = one;
			one = one.next;
			cur = cur.next;
			cur.next = two;
			two = two.next;
			cur = cur.next;
		}
		cur.next = one == null ? two : one;
		return dummy.next;
	}
}
