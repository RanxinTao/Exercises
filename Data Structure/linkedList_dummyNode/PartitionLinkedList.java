package linkedList_dummyNode;

import impl.ListNode;

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummySmall = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode curSmall = dummySmall;
		ListNode curLarge = dummyLarge;
		while (head != null) {
			if (head.value < target) {
				curSmall.next = head;
				curSmall = curSmall.next;
			} else {
				curLarge.next = head;
				curLarge = curLarge.next;
			}
			head = head.next;
		}
		// connect the two partitions
		curSmall.next = dummyLarge.next;
		// un-link the last node in large partition
		curLarge.next = null;
		return dummySmall.next;
	}
}
