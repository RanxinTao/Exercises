package hashMap_hashSet;

import java.util.HashMap;
import java.util.Map;

import impl.RandomListNode;

/**
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. 
 * Make a deep copy of the original list.
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class DeepCopyLinkedListWithRandomPointer {
	public RandomListNode copy(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode pre = dummy;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while (head != null) {
			RandomListNode cur = map.get(head); 
			if (cur == null) {
				cur = new RandomListNode(head.value); // copy the current (head) node if has not been copied before
				map.put(head, cur);
			}
			pre.next = cur; // connect the copied node to the deep copy list
			pre = cur; // update pre
			if (head.random != null) { 
				RandomListNode random = map.get(head.random);
				if (random == null) {
					random = new RandomListNode(head.random.value); // copy head.random only if head.random not null and has not been copied before
					map.put(head.random, random);
				}	
				cur.random = random; // connect the copied node to the random pointer
			}
			head = head.next; // update head
		}
		return dummy.next;
	}
}
