package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 *     Applications Of BFS
 *   - Connected Component
 *   - Bipartite Graph
 *   - Vertex Coloring Algorithm 
 *   - Scheduling Applications
 *   
 */
public abstract class Bfs {
	
	Graph g;
	int startNode;

	public enum State {
		UNDISCOVERED, DISCOVERD, PROCESSED
	}

	ArrayList<State> state;
	ArrayList<Integer> parent;

	public Bfs(Graph g, int startNode){
		this.g = g;
		this.startNode = startNode;
		state = new ArrayList<State>();
		parent = new ArrayList<Integer>();

		for(int i=0;i< g.numOfVerties;i++){
			state.add(i, State.UNDISCOVERED);
			parent.add(i, -1);
		}
	}
	
	
	public void bfsProcess(){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(this.startNode);
		parent.set(startNode, -1);
		state.set(this.startNode, State.DISCOVERD);

		while(!queue.isEmpty()) {
			int currentVertex = queue.remove();

			process_vertex_early(currentVertex);

			Node temp = g.nodes.get(currentVertex);
			while(temp != null){
				if(state.get(temp.label) != State.PROCESSED || this.g.directed)
					process_edge(currentVertex, temp.label);
				if(state.get(temp.label) == State.UNDISCOVERED){
					queue.add(temp.label);
					parent.set(temp.label, currentVertex);
					state.set(temp.label, State.DISCOVERD);
				}
				temp = temp.next;
			}
			state.set(currentVertex, State.PROCESSED);
			process_vertex_late(currentVertex);
		}
	}
	public abstract void process_vertex_late(int currentVertex);
	public abstract void process_edge(int currentVertex, Integer label);
	public abstract void process_vertex_early(int currentVertex);

	public void displayParentArray(){
		for(int i=0; i< this.parent.size(); i++){
			System.out.print(parent.get(i) + ",");
		}
	}
}
