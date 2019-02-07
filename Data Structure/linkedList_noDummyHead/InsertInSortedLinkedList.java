package linkedList_noDummyHead;

import impl.ListNode;

/**
 * Insert a value in a sorted linked list.
 * 
 * Examples:
 * L = null, insert 1, return 1 -> null
 * L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
 * L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
 * L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 * 
 * Time: O(n), Space: O(1)
 */
public class InsertInSortedLinkedList {
	public ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		// determine if the inserted node is before head.
		if (head == null || head.value >= value) {
			newNode.next = head;
			return newNode;
		}
		// insert the new node to the right position.
		ListNode cur = head;
		while (cur.next != null && cur.next.value < value) {
			cur = cur.next;
		}
		newNode.next = cur.next;
		cur.next = newNode;
		return head;
	}
}
