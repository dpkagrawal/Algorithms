package practise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class GraphSearch {
	Graph g;

	public GraphSearch() {
		g = new Graph();
		g.readGraph("data/graph_data.txt");
		System.out.println("size : " + g.nodes.size());
	}

	private enum State {
		DISCOVERED, PROCESSED
	}

	Map<String, State> nodeState = new HashMap<String, State>();

	private boolean isUnDiscovered(String vertex) {
		return !nodeState.containsKey(vertex);
	}

	private boolean isProcessed(String vertex) {
		if (!nodeState.containsKey(vertex))
			return false;
		return nodeState.get(vertex).equals(State.PROCESSED);
	}

	private boolean isDiscovered(String vertex) {
		if (!nodeState.containsKey(vertex))
			return false;
		return nodeState.get(vertex).equals(State.DISCOVERED);
	}

	public void searchBfs(String searchVertex) {
		String startVertex = "0";
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add(startVertex);
		nodeState.put(startVertex, State.DISCOVERED);
		while (!queue.isEmpty()) {
			String currVertex = queue.remove();
			TreeNode currNode = g.nodes.get(currVertex);
			// process early vertex
			if (currNode.nodeId.equals(searchVertex)) {
				System.out.println("found");
			}
			LinkedList<TreeNode> nearby = g.adjList.get(currVertex);
			for (TreeNode n : nearby) {
				if (!isProcessed(n.nodeId)) {
					System.out.println("PROCESS EDGE: " + currVertex + "=>"
							+ n.nodeId);
				}
				if (isUnDiscovered(n.nodeId)) {
					queue.add(n.nodeId);
					nodeState.put(n.nodeId, State.DISCOVERED);
				}
			}
			System.out.println("EXISTING: " + currNode.nodeId);
			nodeState.put(currNode.nodeId, State.PROCESSED);
		}
	}

	public void searchDfs(String currVertex, String searchVertex) {
		// process early vertex
		if (currVertex.equals(searchVertex))
			System.out.println("FOUND");
		nodeState.put(currVertex, State.DISCOVERED);
		LinkedList<TreeNode> nearby = g.adjList.get(currVertex);
		for (TreeNode n : nearby) {
			if (nearby != null && !nearby.isEmpty()) {
				if (!isProcessed(n.nodeId)) {
					System.out.println("PROCESS EDGE: " + currVertex + "=>"
							+ n.nodeId);
				}
				if (isUnDiscovered(n.nodeId))
					searchDfs(n.nodeId, searchVertex);
			}
		}
		System.out.println("EXISTING: " + currVertex);
	}

	public static void main(String[] args) {
		GraphSearch g = new GraphSearch();
		g.searchBfs("7");
		System.out.println("====================");
		GraphSearch g2 = new GraphSearch();
		g2.searchDfs("0", "7");
	}
}
