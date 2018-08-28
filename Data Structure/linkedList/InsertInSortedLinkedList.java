package linkedList;

import impl.ListNode;

public class InsertInSortedLinkedList {
	public ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		// determine if the inserted node is before head.
		if (head == null || head.value >= value) {
			newNode.next = head;
			return newNode;
		}
		// insert the new node to the right position.
		ListNode prev = head;
		while (prev.next != null && prev.next.value < value) {
			prev = prev.next;
		}
		newNode.next = prev.next;
		prev.next = newNode;
		return head;
	}
}
