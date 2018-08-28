package linkedList_dummyNode;

import impl.ListNode;

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
		ListNode prev = dummy;
		while (one != null && two != null) {
			prev.next = one;
			one = one.next;
			prev = prev.next;
			prev.next = two;
			two = two.next;
			prev = prev.next;
		}
		if (one != null) {
			prev.next = one;
		} else {
			prev.next = two;
		}
		return dummy.next;
	}
}
