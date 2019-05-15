package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import impl.GraphNode;

/**
 * Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two
 * groups such that no nodes have direct edges to other nodes in the same group.
 * 
 * Examples:
 * 1 -- 2
 *     /
 *    3 -- 4
 * is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 * 1 -- 2
 *     /  \
 *    3 -- 4
 * is not bipartite.
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		Map<GraphNode, Integer> nodeToGroup = new HashMap<>();
		for (GraphNode node : graph) {
			if (!nodeToGroup.containsKey(node) && !mapNodeToGroup(node, nodeToGroup)) {
				return false;
			}
		}
		return true;
	}

	private boolean mapNodeToGroup(GraphNode node, Map<GraphNode, Integer> nodeToGroup) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.offer(node);
		// start BFS from the node, since the node has not been visited, we can assign it to either group 1 or 2
		nodeToGroup.put(node, 1);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroupNum = nodeToGroup.get(cur);
			int neiGroupNum = curGroupNum == 1 ? 2 : 1;
			for (GraphNode nei : cur.neighbors) {
				// if the neighbor has not been visited, just put it in the queue and choose the correct group
				if (!nodeToGroup.containsKey(nei)) {
					nodeToGroup.put(nei, neiGroupNum);
					queue.offer(nei);
				} else if (nodeToGroup.get(nei) != neiGroupNum) {
					return false;
				}
			}
		}
		return true;
	}
}
