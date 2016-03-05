package graph;

import graph.Bfs.State;

import java.util.ArrayList;

public class Dfs {
	
	
	Graph g;
	int startNode;
	int time=1;
	
	public enum State {
		UNDISCOVERED, DISCOVERD, PROCESSED
	}

	ArrayList<State> state;
	ArrayList<Integer> entryTime;
	ArrayList<Integer> exitTime;
	ArrayList<Integer> parent;
	
	public Dfs(Graph g, int startNode){
		this.g = g;
		this.startNode = startNode;
		state = new ArrayList<State>();
		entryTime = new ArrayList<Integer>();

		for(int i=0;i< g.numOfVerties;i++){
			state.add(i, State.UNDISCOVERED);
			entryTime.add(i, -1);
			exitTime.add(i, -1);
			parent.add(i, -1);
		}
	}
	
	public void dfsProcess(Graph g, int currentVertex){
		
		if(state.get(currentVertex)==State.UNDISCOVERED){
//			process_early_vertex();
			entryTime.set(currentVertex, time);
			state.set(currentVertex, State.DISCOVERD);
			Node temp = g.nodes.get(currentVertex);
			while(temp!=null){
//					process_edge();
				
				
				if(state.get(temp.label) == State.UNDISCOVERED){
					parent.set(temp.label, currentVertex);
					dfsProcess(g, temp.label);
				}
			}
//			process_vertex_late();
			state.set(currentVertex, State.PROCESSED);
			exitTime.set(currentVertex, time);
			time = time+1;
		}
	}
}
