package graph;

public class DfsImplementation extends Dfs {

	int searchVertex ;
	public DfsImplementation(Graph g, int startNode) {
		super(g, startNode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process_vertex_late(int currentVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process_edge(int currentVertex, int otherVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process_vertex_early(int currentVertex) {
		//System.out.println("EARLY VERTEX: " + currentVertex);
		if(currentVertex == searchVertex){
			finished=true;
		}
	}

	public boolean search(int searchVertex){
		finished = false;
		this.searchVertex = searchVertex;
		initializeDefaults();
		dfsProcess(this.g, 0);
		return finished;
	}
	public static void main(String[] args){
		Graph g = new Graph("data/topological_sort.txt");
		DfsImplementation tp = new DfsImplementation(g, 0);
		g.printAdjacencyList();
		System.out.println(tp.search(7));
		System.out.println(tp.search(15));
		System.out.println(tp.search(6));
	}
}
