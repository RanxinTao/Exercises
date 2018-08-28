package hashMap_hashSet;

import java.util.HashMap;
import java.util.Map;

import impl.RandomListNode;

/**
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. 
 * Make a deep copy of the original list.
 */
public class DeepCopyLinkedListWithRandomPointer {
	public RandomListNode copy(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode pre = dummy;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while (head != null) {
			// copy the current node (head)
			RandomListNode cur = map.get(head);
			if (cur == null) {
				cur = new RandomListNode(head.value);
				map.put(head, cur);
			}
			// connect the copied node to the deep copy list
			pre.next = cur;
			// copy head.random (head.random can be null)
			if (head.random != null) {
				RandomListNode random = map.get(head.random);
				if (random == null) {
					random = new RandomListNode(head.random.value);
					map.put(head.random, random);
				}
				// connect the copied node to the random pointer
				cur.random = random;
			}
			// update pre and head
			pre = cur;
			head = head.next;
		}
		return dummy.next;
	}
}
