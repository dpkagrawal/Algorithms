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
public abstract class Dfs {
	Graph g;
	int startNode;
	int time = 1;
	boolean finished=false;

	public enum State {
		UNDISCOVERED, DISCOVERED, PROCESSED
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
		exitTime = new ArrayList<Integer>();
		parent = new ArrayList<Integer>();
		initializeDefaults();
	}
	
	public void initializeDefaults(){
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
		System.out
				.println("Warning: unclassified edge (%d,%d)\n" + x + "," + y);
		return (EdgeType.TREE);
	}

	 boolean isDiscovered(int vertex) {
		return state.get(vertex) == State.DISCOVERED;
	}
	 
	boolean isUnDiscovered(int vertex) {
			return state.get(vertex) == State.UNDISCOVERED;
	 }

	boolean isProcessed(int vertex) {
		return state.get(vertex) == State.PROCESSED;
	}

	
	/*
	 * Time is incremented each time we enter or exit the node, which can be used to keep track of parent/ancestor
	 */
	public void dfsProcess(Graph g, int currentVertex) {
		if (isUnDiscovered(currentVertex)) {

			if(finished) return;
			process_vertex_early(currentVertex);
			state.set(currentVertex, State.DISCOVERED);
			time = time+1;
			entryTime.set(currentVertex, time);

			Node otherVertex = g.nodes.get(currentVertex);
			while (otherVertex != null) {
				if (isUnDiscovered(otherVertex.label)) {
					parent.set(otherVertex.label, currentVertex);
					process_edge(currentVertex, otherVertex.label);
					dfsProcess(g, otherVertex.label);
				} 
				else if ((!isProcessed(otherVertex.label)) || (g.directed)){
					process_edge(currentVertex, otherVertex.label); // not sure
				}
				if(finished) return;
				otherVertex = otherVertex.next;
			}
			process_vertex_late(currentVertex);

			time = time + 1;
			exitTime.set(currentVertex, time);
			state.set(currentVertex, State.PROCESSED);
			
		}
	}

	public abstract void process_vertex_late(int currentVertex);

	public abstract void process_edge(int currentVertex, int otherVertex);

	public abstract void process_vertex_early(int currentVertex);
}
