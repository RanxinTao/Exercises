package impl;

public class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
	}
	
	public ListNode(int[] values) {
		this(values[0]);
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		for(int i = 1; i < values.length; i++) {
			ListNode node = new ListNode(values[i]);
			pre.next = node;
			pre = pre.next;
		}
		next = dummy.next;
	}

	@Override
	public String toString() {
		ListNode node = this;
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		node = node.next;
		while(node != null) {
			sb.append(" -> ");
			sb.append(node.value);
			node = node.next;
		}
		return sb.toString();
	}
}
