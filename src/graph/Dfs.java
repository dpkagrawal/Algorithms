package graph;

import java.util.ArrayList;

/*
 *  Topological sorting 
 *  Bi- connected/strongly-connected components
 *  
 *  
 *  Property of DFS:
 *  tree edges and back edges
 */
public class Dfs {
	Graph g;
	int startNode;
	int time = 1;
	

	public enum State {
		UNDISCOVERED, DISCOVERD, PROCESSED
	}
	
	public enum EdgeType {
		TREE, BACK, FORWARD, CROSS
	}

	ArrayList<State> state;
	ArrayList<Integer> entryTime;
	ArrayList<Integer> exitTime;
	ArrayList<Integer> parent;

	public Dfs(Graph g, int startNode) {
		this.g = g;
		this.startNode = startNode;
		state = new ArrayList<State>();
		entryTime = new ArrayList<Integer>();
		for (int i = 0; i < g.numOfVerties; i++) {
			state.add(i, State.UNDISCOVERED);
			entryTime.add(i, -1);
			exitTime.add(i, -1);
			parent.add(i, -1);
		}
	}

	EdgeType edgeClassification(int x, int y) {
		if (parent.get(y) == x)
			return (EdgeType.TREE);
		if (isDiscovered(y) && !isProcessed(y))
			return (EdgeType.BACK);
		if (isProcessed(y) && (entryTime.get(y) > entryTime.get(x)))
			return (EdgeType.FORWARD);
		if (isProcessed(y) && (entryTime.get(y) < entryTime.get(x)))
			return (EdgeType.CROSS);
		System.out.println("Warning: unclassified edge (%d,%d)\n" + x + "," + y);
		return (EdgeType.TREE);

	}

	
	private boolean isDiscovered(int vertex){
		return state.get(vertex) == State.DISCOVERD;
	}

	private boolean isProcessed(int vertex){
		return state.get(vertex) == State.UNDISCOVERED;
	}

	public void dfsProcess(Graph g, int currentVertex) {
		if (!isDiscovered(currentVertex)) {
			// process_early_vertex();
			entryTime.set(currentVertex, time);
			state.set(currentVertex, State.DISCOVERD);
			Node temp = g.nodes.get(currentVertex);
			while (temp != null) {
				// process_edge();
				if (state.get(temp.label) == State.UNDISCOVERED) {
					parent.set(temp.label, currentVertex);
					dfsProcess(g, temp.label);
				}
			}
			// process_vertex_late();
			state.set(currentVertex, State.PROCESSED);
			exitTime.set(currentVertex, time);
			time = time + 1;
		}
	}
}
