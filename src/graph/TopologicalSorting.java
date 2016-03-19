package graph;

import java.util.Stack;


// https://en.wikipedia.org/wiki/Topological_sorting
public class TopologicalSorting extends Dfs {

	
	Stack<Integer> order = new Stack<Integer>();
	public TopologicalSorting(Graph g, int startNode) {
		super(g, startNode);
	}

	@Override
	public void process_vertex_late(int currentVertex) {
		order.add(currentVertex);
	}

	@Override
	public void process_edge(int currentVertex, int otherVertex) {
		if(edgeClassification(currentVertex, otherVertex)==EdgeType.BACK){
			System.out.println("BACK EDGE Present : " + currentVertex + " to " + otherVertex);
			finished=true;
		}
		
	}

	@Override
	public void process_vertex_early(int currentVertex) {
		// TODO Auto-generated method stub
		
	}
	
	public void topologicalSort(){
		g.printAdjacencyList();
		for(int i=0;i<g.numOfVerties;i++){
			Node n = this.g.nodes.get(i);
			if(n!=null && !isDiscovered(n.label)){
				System.out.println("CALLING FOR : " + i);
				dfsProcess(g, i);
			}
		}
		System.out.println(order);
		System.out.println(order.peek());
	}
	
	public static void main(String[] args){
		Graph g = new Graph("data/topological_sort.txt");
		TopologicalSorting tp = new TopologicalSorting(g, 0);
		tp.topologicalSort();
	}
}
