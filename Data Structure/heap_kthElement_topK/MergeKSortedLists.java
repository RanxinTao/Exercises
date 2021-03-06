package heap_kthElement_topK;

import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

import impl.ListNode;

/**
 * Merge K sorted lists into one big sorted list in ascending order.
 * 
 * Assumptions:
 * The input ListOfLists is not null, and none of the lists is null.
 * 
 * Algorithm: move the smaller one
 * Time: O(knlogk), where n is the average length of lists
 * Space: O(k)
 */
public class MergeKSortedLists {
	public ListNode merge(List<ListNode> listOfLists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode head1, ListNode head2) {
				return ((Integer) head1.value).compareTo(head2.value);
			}
		});
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		for (ListNode head : listOfLists) {
			if (head != null) {
				minHeap.offer(head);
			}
		}
		while (!minHeap.isEmpty()) {
			ListNode curNode = minHeap.poll();
			pre.next = curNode;
			pre = pre.next;
			if (curNode.next != null) {
				minHeap.offer(curNode.next);
			}
		}
		return dummy.next;
	}
}
