package linkedList_dummyNode;

import impl.ListNode;

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy_small = new ListNode(0);
		ListNode dummy_large = new ListNode(0);
		ListNode prev_small = dummy_small;
		ListNode prev_large = dummy_large;
		while (head != null) {
			if (head.value < target) {
				prev_small.next = head;
				prev_small = prev_small.next;
			} else {
				prev_large.next = head;
				prev_large = prev_large.next;
			}
			head = head.next;
		}
		// connect the two partitions
		prev_small.next = dummy_large.next;
		// un-link the last node in large partition
		prev_large.next = null;
		return dummy_small.next;
	}
}
