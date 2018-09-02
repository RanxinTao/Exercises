package linkedList_dummyNode;

import impl.ListNode;

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
