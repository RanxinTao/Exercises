package linkedList_dummyNode;

import impl.ListNode;

public class MergeTwoSortedLinkedLists {
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while (one != null && two != null) {
			if (one.value <= two.value) {
				prev.next = one;
				one = one.next;
			} else {
				prev.next = two;
				two = two.next;
			}
			prev = prev.next;
		}
		// link the remaining possible nodes
		if (one != null) {
			prev.next = one;
		} else {
			prev.next = two;
		}
		return dummy.next;
	}
}
