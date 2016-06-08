package practise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class Graph {
	int numOfVertices;
	int numOfEdges;
	boolean directed;
	public Map<String, LinkedList<TreeNode>> adjList = new HashMap<String, LinkedList<TreeNode>>();
	public Map<String, TreeNode> nodes = new HashMap<String, TreeNode>();
	
	public Graph(){
		
	}



	public void insert_edge(String vertex1, String vertex2) {
		TreeNode v2;
		if (nodes.containsKey(vertex2)) {
			v2 = nodes.get(vertex2);
			v2.degree++;
		} else {
			v2 = new TreeNode(vertex2, 1);
			nodes.put(vertex2, v2);
		}


		TreeNode v1;
		if (nodes.containsKey(vertex1)) {
			v1 = nodes.get(vertex1);
			v1.degree++;
		} else {
			v1 = new TreeNode(vertex1, 1);
			nodes.put(vertex1, v1);
		}

		if (adjList.containsKey(vertex1)) {
			adjList.get(vertex1).add(v2);
		} else {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(v2);
			adjList.put(vertex1, list);
		}

		if (adjList.containsKey(vertex2)) {
			adjList.get(vertex2).add(v1);
		} else {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(v1);
			adjList.put(vertex2, list);
		}
	}


	public void readGraph(String fileName){
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			line = reader.readLine();
			if(line!=null){
				this.directed = Boolean.parseBoolean(line);
			}

			line = reader.readLine();
			if(line!=null){
				int num = Integer.parseInt(line);
			}

			while((line = reader.readLine()) !=null){
				String [] vertices = line.split("\\s+");
				if(vertices!=null && vertices.length==2){
					insert_edge(vertices[0], vertices[1]);
				} else {
					System.out.println("Invalid file for graph: " + fileName);
				}
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printAdjacencyList(){
		for(String nodeId : adjList.keySet()){
			TreeNode currNode = nodes.get(nodeId);
			System.out.print("Degree: " +  currNode.degree + " Current Node: " + nodeId + "=> ");
			for(TreeNode n : adjList.get(nodeId)){
				System.out.print(n.nodeId +",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		Graph g = new Graph();
		g.readGraph("data/graph_data.txt");
		g.printAdjacencyList();
	
	}
}
