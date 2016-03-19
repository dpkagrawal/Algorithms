package others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Dfs {
	
	List<LinkedList<Integer>> adjM;
	int numOfVertices;
	
	public Dfs(int v){
		this.numOfVertices = v;
		adjM = new ArrayList<LinkedList<Integer>>();
		
		for(int i=0;i< numOfVertices;i++){
			adjM.add(new LinkedList<Integer>());
		}
	}
	
	public void insert(int v, int u){
		adjM.get(v).add(u);
		adjM.get(u).add(v);
	}
	
	
	public void dfsUtil(int currentVertex, int searchVertex, boolean[] visited){
		
		if(currentVertex==searchVertex){
			System.out.println("FOUND");
		}
		
		System.out.println("VISTED: " + currentVertex);
		visited[currentVertex] = true;
		
		Iterator<Integer> i =  adjM.get(currentVertex).iterator();
		
		while(i.hasNext()){
			int nextVertex = i.next();
			
			if(!visited[nextVertex]){
				dfsUtil(nextVertex, searchVertex, visited);
			}
		}
		
		
		
	}
	
	public void dfsSearch(int searchVertex){
		boolean[] visited = new boolean[numOfVertices];
		
		
		
		for(int i=0;i< adjM.size();i++){
			if(!visited[i]){
				dfsUtil(i, searchVertex, visited);
			}
		}
	}
	 public static void main(String args[])
	    {
	        Dfs g = new Dfs(8);
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
	 
	        g.dfsSearch(3);
	    }
	
	
}
