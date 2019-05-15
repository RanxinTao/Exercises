package linkedList_dummyHead;

import impl.ListNode;

/**
 * Merge two sorted lists into one large sorted list.
 * 
 * Examples:
 * L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
 * L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
 * L1 = null, L2 = null, merge L1 and L2 to null
 * 
 * Time: O(l1 + l2)
 * Space: O(1)
 */
public class MergeTwoSortedLinkedLists {
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			if (one.value <= two.value) {
				cur.next = one;
				one = one.next;
			} else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		// link the remaining possible nodes
		cur.next = one == null ? two : one;
		return dummy.next;
	}
}
