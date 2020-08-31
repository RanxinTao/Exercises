package addTwoNumbers;

import impl.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it
 * as a linked list.
 * 
 * Examples:
 * 1. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)	Output: 7 -> 0 -> 8
 * 
 * Time: O(m + n), where m and n are the length of the two linked lists.
 * Space: auxiliary O(m + n)
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = (l1 == null ? 0 : l1.value) + (l2 == null ? 0 : l2.value) + carry;
			carry = sum / 10;
			sum = sum % 10;
			pre.next = new ListNode(sum);
			pre = pre.next;
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}
		if (carry != 0) {
			pre.next = new ListNode(carry);
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers test = new AddTwoNumbers();
		ListNode l1 = new ListNode(new int[] {2, 4, 3});
		ListNode l2 = new ListNode(new int[] {5, 6, 4});
		System.out.println("l1: " + l1);
		System.out.println("l2: " + l2);
		System.out.println(test.addTwoNumbers(l1, l2));
	}
}
