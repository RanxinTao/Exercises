package linkedList_noDummyHead;

import impl.ListNode;

/**
 * Reverse pairs of elements in a singly-linked list.
 * 
 * Examples: 
 * 1. L = null, after reverse is null
 * 2. L = 1 -> null, after reverse is 1 -> null
 * 3. L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
 * 4. L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseLinkedListInPairs {
	public ListNode reverseInPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;
			head = second.next; // move head pointer to the next pair
			pre.next = second; // add the second node into the dummy list
			pre = pre.next;			
			pre.next = first; // add the first node into the dummy list
			pre = pre.next;	
		}
		pre.next = head; // link the remaining possible nodes
		return dummy.next;
	}
}
