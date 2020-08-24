package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import impl.GraphNode;

/**
 * Make a deep copy of an undirected graph, there could be cycles in the original graph.
 * 
 * Assumptions:
 * The given graph is not null
 * 
 * Algorithm: BFS
 * Time: O(V + E)
 * Space: O(V)
 */
public class DeepCopyUndirectedGraph {
	public List<GraphNode> copy(List<GraphNode> graph) {
		List<GraphNode> res = new ArrayList<>();
		Map<GraphNode, GraphNode> originToCopy = new HashMap<>();
		Queue<GraphNode> queue = new LinkedList<>();
		for (GraphNode graphNode : graph) {
			if (!originToCopy.containsKey(graphNode)) {
				queue.offer(graphNode);
			}
			while (!queue.isEmpty()) {
				GraphNode cur = queue.poll();
				GraphNode curCopy = originToCopy.get(cur);
				if (curCopy == null) {
					curCopy = new GraphNode(cur.key);
					originToCopy.put(cur, curCopy);
				}
				for (GraphNode nei : cur.neighbors) {
					GraphNode neiCopy = originToCopy.get(nei);
					if (neiCopy == null) {
						neiCopy = new GraphNode(nei.key);
						originToCopy.put(nei, neiCopy);
						queue.offer(nei); // add into the queue only if not visited before
					}
					curCopy.neighbors.add(neiCopy);		
				}
				res.add(curCopy);
			}	
		}
		return res;
	}
}
