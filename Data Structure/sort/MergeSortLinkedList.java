package sort;

import impl.ListNode;

public class MergeSortLinkedList {
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode left = head;
		ListNode right = slow.next;
		slow.next = null;
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (left != null && right != null) {
			if (left.value < right.value) {
				pre.next = left;
				left = left.next;
			} else {
				pre.next = right;
				right = right.next;
			}
			pre = pre.next;
		}
		if (left != null) {
			pre.next = left;
		} else {
			pre.next = right;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		MergeSortLinkedList test = new MergeSortLinkedList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(2);
		System.out.println(test.mergeSort(head));
	}
}
