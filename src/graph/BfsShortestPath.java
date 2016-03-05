package graph;

public class BfsShortestPath extends Bfs {
	int totalEdges = 0;
	int totalVertices = 0;
	public BfsShortestPath(Graph g, int startNode) {
		super(g, startNode);
	}

	@Override
	public void process_edge(int x, Integer y) {
		totalEdges++;
//		System.out.println("Edge: " + x + " to " + y);
	}

	@Override
	public void process_vertex_early(int currentVertex) {
		totalVertices++;
//		System.out.print(currentVertex + "|");
	}

	public static void main(String[] args) {
		Graph g = new Graph("graph_data.txt");
		BfsShortestPath bfs = new BfsShortestPath(g, 0);
		bfs.bfsProcess();
		bfs.displayParentArray();
		System.out.println("Total Edges: " + bfs.totalEdges);
		System.out.println("Total Vertices: " + bfs.totalVertices);
		
	}

	@Override
	public void process_vertex_late(int currentVertex) {
		// TODO Auto-generated method stub
		
	}
}
