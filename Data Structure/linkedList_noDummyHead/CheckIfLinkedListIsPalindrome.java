package linkedList_noDummyHead;

import impl.ListNode;

public class CheckIfLinkedListIsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		// 1. find the middle node.
		ListNode mid = middleNode(head);
		ListNode one = head;
		ListNode two = mid.next;
		// de-link the second half from the list.
		mid.next = null;
		// 2. reverse the second half.
		two = reverse(two);
		return areSame(one, two);
	}
	
	private ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	private boolean areSame(ListNode head1, ListNode head2) {
		while (head1 != null && head2 != null) {
			if (head1.value != head2.value) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckIfLinkedListIsPalindrome test = new CheckIfLinkedListIsPalindrome();
		ListNode head = new ListNode(new int[] {1, 2, 2, 1});
		System.out.println(test.isPalindrome(head));
	}
}
