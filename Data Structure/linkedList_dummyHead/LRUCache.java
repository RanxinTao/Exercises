package linkedList_dummyHead;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	// the max capacity of the cache
	private final int limit;
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
		// cache hit, we update the existing node
		if (node != null) {
			node.value = value;
			remove(node);
		// cache miss, we create and add a new node
		} else { // node == null
			node = new Node<K, V>(key, value);
			// check capacity
			if (map.size() >= limit) {
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

	// remove a node from LRU
	private void remove(Node<K, V> node) {
		map.remove(node.key);
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	// append to tail
	private void append(Node<K, V> node) {
		map.put(node.key, node);
		node.prev = dummyTail.prev;
		node.next = dummyTail;
		dummyTail.prev.next = node;
		dummyTail.prev = node;
	}

	static class Node<K, V> {
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
