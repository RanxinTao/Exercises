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
		Map<GraphNode, GraphNode> originToCopy = new HashMap<>();
		List<GraphNode> res = new ArrayList<>();
		for (GraphNode cur : graph) {
			res.add(DFS(cur, originToCopy));
		}
		return res;
	}

	// return the copy of the current GraphNode if exists in map, otherwise create first then return it
	private GraphNode DFS(GraphNode cur, Map<GraphNode, GraphNode> originToCopy) {
		GraphNode curCopy = originToCopy.get(cur);
		if (curCopy != null) {
			return curCopy;
		}
		curCopy = new GraphNode(cur.key);
		// in case there are self-cycles, this statement must be performed before the for loop
		originToCopy.put(cur, curCopy);
		for (GraphNode nei : cur.neighbors) {
			GraphNode neiCopy = DFS(nei, originToCopy);
			curCopy.neighbors.add(neiCopy);
		}
		return curCopy;
	}
}
