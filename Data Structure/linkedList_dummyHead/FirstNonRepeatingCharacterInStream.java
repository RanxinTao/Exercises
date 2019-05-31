package linkedList_dummyHead;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a stream of characters, find the first non-repeating character from stream. You need to tell the first
 * non-repeating character in O(1) time at any moment.
 * Implement two methods of the class:
 * 1. read() - read one character from the stream
 * 2. firstNonRepeating() - return the first non-repeating character from the stream at any time when calling the 
 * method. Return null if there does not exist such characters.
 * 
 * Examples:
 * read: a, b, c, a, c, c, b
 * firstNonReapting: a, a, a, b, b, b, null
 */
public class FirstNonRepeatingCharacterInStream {
	private Node dummyHead;
	private Node dummyTail;
	private Map<Character, Node> mapCharToNode;
	private Set<Character> visited;
	
	public FirstNonRepeatingCharacterInStream() {
		dummyHead = new Node('0');
		dummyTail = new Node('0');
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
		mapCharToNode = new HashMap<>();
		visited = new HashSet<>();
	}
	
	public void read(char ch) {
		if (visited.add(ch)) {
			append(new Node(ch));
		} else {
			Node node = mapCharToNode.get(ch);
			if (node != null) {
				remove(node);
			}
		}
	}
	
	private void remove(Node node) {
		mapCharToNode.remove(node.value);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void append(Node node) {
		mapCharToNode.put(node.value, node);
		node.prev = dummyTail.prev;
		node.next = dummyTail;
		dummyTail.prev.next = node;
		dummyTail.prev = node;
	}
	
	public Character firstNonRepeating() {
		return dummyHead.next == dummyTail ? null : dummyHead.next.value;
	}
		
	static class Node {
		char value;
		Node next;
		Node prev;
		
		public Node(char value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		FirstNonRepeatingCharacterInStream test = new FirstNonRepeatingCharacterInStream();
		System.out.println(test.firstNonRepeating());
		test.read('a'); System.out.println(test.firstNonRepeating());
		test.read('b'); System.out.println(test.firstNonRepeating());
		test.read('c'); System.out.println(test.firstNonRepeating());
		test.read('a'); System.out.println(test.firstNonRepeating());
		test.read('c'); System.out.println(test.firstNonRepeating());
		test.read('c'); System.out.println(test.firstNonRepeating());
		test.read('b'); System.out.println(test.firstNonRepeating());
	}
}

