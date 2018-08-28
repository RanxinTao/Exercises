package sort;

import impl.ListNode;

public class SelectionSortLinkedList {
	public ListNode selectionSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode sortedDummy = new ListNode(0);
		ListNode sortedHead = sortedDummy;
		ListNode unsortedDummy = new ListNode(0);
		// link head to unsortedDummy, and set head to the dummy node
		unsortedDummy.next = head;
		head = unsortedDummy;
		while (head.next != null) {
			// maintain preSmallest.next = the node with the smallest value
			ListNode preSmallest = head;
			while (head.next != null) {
				if (preSmallest.next.value > head.next.value) {
					preSmallest = head;
				}
				head = head.next;
			}
			// insert the smallest node into the sorted part
			sortedHead.next = preSmallest.next;
			sortedHead = sortedHead.next;
			// remove the smallest node from unsorted part
			preSmallest.next = preSmallest.next.next;
			// reset head
			head = unsortedDummy;
		}
		return sortedDummy.next;
	}

	public static void main(String[] args) {
		SelectionSortLinkedList test = new SelectionSortLinkedList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);
		System.out.println(test.selectionSort(head));
	}
}
