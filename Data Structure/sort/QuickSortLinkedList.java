package sort;

import impl.ListNode;

/**
 * Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
 * The quick sort algorithm should be used to solve this problem.
 * 
 * Examples:
 * 1. null, is sorted to null
 * 2. 1 -> null, is sorted to 1 -> null
 * 3. 1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
 * 4. 4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
 */
public class QuickSortLinkedList {
	public ListNode quickSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode smallerHead = partition(head);
		// during partition, head became pivot
		ListNode largerHead = head.next;
		smallerHead = quickSort(smallerHead);
		largerHead = quickSort(largerHead);
		// link pivot with sorted larger half
		head.next = largerHead;
		if (smallerHead == null) {
			return head;
		}
		ListNode cur = smallerHead;
		while (cur.next != null) {
			cur = cur.next;
		}
		// link sorted smaller half with pivot
		cur.next = head;
		return smallerHead;
	}

	private ListNode partition(ListNode head) {
		ListNode pivot = head;
		ListNode smallerDummy = new ListNode(0);
		ListNode smaller = smallerDummy;
		ListNode largerDummy = new ListNode(0);
		ListNode larger = largerDummy;
		head = head.next;
		while (head != null) {
			if (head.value <= pivot.value) {
				smaller.next = head;
				smaller = smaller.next;
			} else {
				larger.next = head;
				larger = larger.next;
			}
			head = head.next;
		}
		smaller.next = null;
		larger.next = null;
		// link pivot with larger half
		pivot.next = largerDummy.next;
		return smallerDummy.next;
	}
	
	public static void main(String[] args) {
		QuickSortLinkedList test = new QuickSortLinkedList();
		ListNode head = new ListNode(new int[] {4,2,6,-3,5});
		System.out.println(test.quickSort(head));
	}
}
