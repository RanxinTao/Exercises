package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import impl.GraphNode;

/**
 * Make a deep copy of an undirected graph, there could be cycles in the original graph.
 * Assumptions:
 * The given graph is not null
 */
public class DeepCopyUndirectedGraph {
	public List<GraphNode> copy(List<GraphNode> graph) {
		Map<GraphNode, GraphNode> map = new HashMap<>();
		List<GraphNode> res = new ArrayList<>();
		for (GraphNode cur : graph) {
			res.add(DFS(cur, map));
		}
		return res;
	}

	// return the copy of GraphNode cur if exists in map, otherwise create and return a copy
	private GraphNode DFS(GraphNode cur, Map<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(cur);
		if (copy == null) {
			copy = new GraphNode(cur.key);
			// in case there are self-cycles, this statement must be performed before the for loop
			map.put(cur, copy);
			for (GraphNode neighbor : cur.neighbors) {
				copy.neighbors.add(DFS(neighbor, map));
			}
		}
		return copy;
	}
}
