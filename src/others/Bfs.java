package others;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bfs {
	
	
		private LinkedList<Integer>[] adjList ;
		int numOfVertices ;
		
		public Bfs(int n){
			this.numOfVertices = n;
			adjList = new LinkedList[n];
			for(int i=0;i<n;i++){
				adjList[i] =  new LinkedList<Integer>();
			}
		}
		
		public void insert(int v, int u){
			adjList[v].add(u);
		}

		public void bfsUtils(int currentVertex, int searchVertex, boolean[] visited){
			Queue<Integer> q = new PriorityQueue<Integer>();
			q.add(currentVertex);
			visited[currentVertex] = true;

			while(!q.isEmpty()){
				int curV = q.remove();
				
				System.out.println("VISITED: " + curV);
				if(curV==searchVertex)
					System.out.println("Found");
				
				
				for(Integer adj: adjList[curV]){
					if(!visited[adj]){
						visited[adj] = true;
						q.add(adj);
					}
				}
			}
		}
		public void searchBfs(int searchVertex){
			
			
			boolean[] visited = new boolean[this.numOfVertices];
			for(int i=0;i< adjList.length; i++){
				if(!visited[i]){
					bfsUtils(i, searchVertex, visited);
				}
			}
		}
		 public static void main(String args[])
		    {
		        Bfs g = new Bfs(8);
		        g.insert( 0, 1);
		        g.insert(0,6);
		        g.insert(0, 5);
		        g.insert(1, 2);
		        g.insert(1 ,5);
		        g.insert(2, 3);
		        g.insert(2, 4);
		        g.insert(3, 4);
		        g.insert(4, 7);
		        g.insert(4, 5);
		 
		        System.out.println("Following is Depth First Traversal");
		 
		        g.searchBfs(3);
		    }
}
