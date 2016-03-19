package graph;

public class ShortestPath {
	static final int V = 9;

	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		ShortestPath t = new ShortestPath();
		t.dijkstra(graph, 0);
	}

	public int getMin(int[] dist, boolean[] inPath) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < V; i++) {
			if (!inPath[i] && dist[i] <= min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private void dijkstra(int[][] graph, int start) {
		boolean[] inPath = new boolean[V];
		int[] dist = new int[V];
		for (int i = 0; i < V; i++){
			dist[i] = Integer.MAX_VALUE;
			inPath[i]=false;
		}
		dist[start] = 0;
		for (int count = 0; count < V; count++) {
			int u = getMin(dist, inPath);
			inPath[u] = true;
			for (int v = 0; v < V; v++) {
				if (!inPath[v] && graph[u][v] != 0
						&& dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		printSolution(dist, V);
	}

	void printSolution(int dist[], int n) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}
}
