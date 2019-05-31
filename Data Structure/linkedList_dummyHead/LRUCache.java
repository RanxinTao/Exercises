package linkedList_dummyHead;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null.
 */
public class LRUCache<K, V> {
	private final int limit; // the max capacity of the cache
	private Node<K, V> dummyHead;
	private Node<K, V> dummyTail;
	private Map<K, Node<K, V>> map;

	public LRUCache(int limit) {
		this.limit = limit;
		this.map = new HashMap<>();
		dummyHead = new Node<K, V>(null, null);
		dummyTail = new Node<K, V>(null, null);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	public void set(K key, V value) {
		Node<K, V> node = map.get(key);
		if (node != null) { // cache hit, we update the existing node
			node.value = value; 
			remove(node);
		} else { // node == null, means cache miss, we create and add a new node
			node = new Node<K, V>(key, value);
			if (map.size() >= limit) { // check capacity
				remove(dummyHead.next);
			}
		}
		append(node);
	} 

	public V get(K key) {
		Node<K, V> node = map.get(key);
		if (node == null) {
			return null;
		}
		remove(node);
		append(node);
		return node.value;
	}

	private void remove(Node<K, V> node) { // remove a node from LRU
		map.remove(node.key);
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	private void append(Node<K, V> node) { // append to tail
		map.put(node.key, node);
		node.prev = dummyTail.prev;
		node.next = dummyTail;
		dummyTail.prev.next = node;
		dummyTail.prev = node;
	}

	static class Node<K, V> { // must include key as a member variable in class Node otherwise it's impossible to delete key from map when delete the node from the list due to limit
		Node<K, V> next;
		Node<K, V> prev;
		K key;
		V value;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
