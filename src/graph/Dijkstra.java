package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
	static final int V = 4;

	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
		/*
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		*/
		int graph[][] = new int[][] { {0,5,1,0},
				{5,0,1,0}, {1,1,0,2}, {0,0,2,0}
		};
		Dijkstra t = new Dijkstra();
		t.dijkstra(graph, 0);
		t.intializeAdj(0);
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
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			inPath[i] = false;
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

	class GraphNode {
		int label;
		int weight;

		public GraphNode(int label, int weight) {
			this.label = label;
			this.weight = weight;
		}
	}

	private void intializeAdj(int start) {
		List<List<GraphNode>> adjList = new ArrayList<List<GraphNode>>();
		List<GraphNode> first = new ArrayList<GraphNode>();
		
		first.add(new GraphNode(1, 5));
		first.add(new GraphNode(2, 1));
		adjList.add(first);

		first = new ArrayList<GraphNode>();
		first.add(new GraphNode(0, 5));
		first.add(new GraphNode(2, 1));
		adjList.add(first);
		

		first = new ArrayList<GraphNode>();
		first.add(new GraphNode(0, 1));
		first.add(new GraphNode(1, 1));
		first.add(new GraphNode(3, 2));
		
		adjList.add(first);
		first = new ArrayList<GraphNode>();
		first.add(new GraphNode(2, 2));
		adjList.add(first);
		
		
		System.out.println("====");
		dijskstraUsingAdjacentList(adjList, start);
	}

	private void dijskstraUsingAdjacentList(List<List<GraphNode>> adjList, int start) {
		System.out.println(adjList.size());
		int[] distance = new int[adjList.size()];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		int current = start;
		
		
		Queue<GraphNode> q = new PriorityQueue<GraphNode>(adjList.size(),  new Comparator<GraphNode>() {
			@Override
			public int compare(GraphNode o1, GraphNode o2) {
				return o1.weight - o2.weight;
			}
		});
		
		for(int vertex=0; vertex< adjList.size(); vertex++){
			List<GraphNode> children = adjList.get(vertex);
			
			Collections.sort(children, new Comparator<GraphNode>() {

				@Override
				public int compare(GraphNode o1, GraphNode o2) {
					return o1.weight - o2.weight;
				}
			});
			
			for(int i=0;i< children.size();i++){
				GraphNode child = children.get(i);
				
				int distanceToChild = distance[current] + child.weight;
				
				if(distanceToChild < distance[child.label]){
					distance[child.label] = distanceToChild;
				}
			}
			
			
		}
		
		System.out.println("+++++");
		for(int i=0;i<distance.length;i++)
			System.out.println(distance[i]);
	}

	void printSolution(int dist[], int n) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}
}
