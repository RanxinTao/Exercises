package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import impl.GraphNode;

/**
 * Make a deep copy of an undirected graph, there could be cycles in the original graph.
 * 
 * Assumptions:
 * The given graph is not null
 * 
 * Algorithm: DFS (easier to write than BFS for this problem, because constructing edges need the current node and its
 * neighbor nodes both present in a same loop, you can't simply add neighbors to the queue and let next loop handle it,
 * in contrast to a simple graph iteration)
 * Time: O(V + E)
 * Space: O(V)
 */
public class DeepCopyUndirectedGraph {
	public List<GraphNode> copy(List<GraphNode> graph) {
		List<GraphNode> res = new ArrayList<>();
		Map<GraphNode, GraphNode> originToCopy = new HashMap<>();	
		for (GraphNode curNode : graph) {
			res.add(getNodeCopy(curNode, originToCopy));
		}
		return res;
	}
	
	private GraphNode getNodeCopy(GraphNode cur, Map<GraphNode, GraphNode> originToCopy) { // DFS to get the copy of the input original graph node
		GraphNode curCopy = originToCopy.get(cur);
		if (curCopy != null) {
			return curCopy; // return the copy of the input original graph node if its copy already exists in the map
		}
		curCopy = new GraphNode(cur.key); // if not exists in the map, we need to create one and return it
		originToCopy.put(cur, curCopy); // in case there are self-cycles, this statement must be performed before the for loop
		for (GraphNode nei : cur.neighbors) {
			GraphNode neiCopy = getNodeCopy(nei, originToCopy);
			curCopy.neighbors.add(neiCopy);
		}
		return curCopy;
	}
}
