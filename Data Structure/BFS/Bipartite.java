package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import impl.GraphNode;

public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		Map<GraphNode, Integer> nodeToGroup = new HashMap<>();
		for (GraphNode node : graph) {
			if (!nodeToGroup.containsKey(node) && !BFS(node, nodeToGroup)) {
				return false;
			}
		}
		return true;
	}

	private boolean BFS(GraphNode node, Map<GraphNode, Integer> nodeToGroup) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.offer(node);
		// start BFS from the node, since the node has not been visited, we can assign it to either group 1 or 2
		nodeToGroup.put(node, 1);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = nodeToGroup.get(cur);
			int neiGroup = curGroup == 1 ? 2 : 1;
			for (GraphNode nei : cur.neighbors) {
				// if the neighbor has not been visited, just put it in the queue and choose the correct group
				if (!nodeToGroup.containsKey(nei)) {
					nodeToGroup.put(nei, neiGroup);
					queue.offer(nei);
				} else if (nodeToGroup.get(nei) != neiGroup) {
					return false;
				}
			}
		}
		return true;
	}
}
