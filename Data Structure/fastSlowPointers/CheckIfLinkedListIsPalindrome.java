package fastSlowPointers;

import impl.ListNode;

/**
 * Given a linked list, check whether it is a palindrome.
 * Requirements: space complexity must be O(1).
 * 
 * Examples:
 * 1. Input: 1 -> 2 -> 3 -> 2 -> 1 -> null	Output: true.
 * 2. Input: 1 -> 2 -> 3 -> null	Output: false.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class CheckIfLinkedListIsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode mid = middleNode(head); // 1. find the middle node.
		ListNode one = head;
		ListNode two = mid.next;
		mid.next = null; // de-link the second half from the list.
		two = reverse(two); // 2. reverse the second half.
		return areSame(one, two);
	}
	
	private ListNode middleNode(ListNode head) { // return the middle node if there are odds nodes, return the last node of the first half if there are even nodes
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
