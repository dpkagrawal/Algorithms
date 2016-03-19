package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	
	final int MAX_VERTEX=100;
	int numOfVerties;
	int numOfEdges;
	ArrayList<Integer> degrees;
	boolean directed;
	ArrayList<Node> nodes;


	public Graph(String fileName){
		degrees = new ArrayList<Integer>();
		nodes = new ArrayList<Node>();
		numOfEdges=0;
		numOfVerties=0;
		/*
		 * Initializing the graph
		 */
		for(int i=0; i<MAX_VERTEX; i++){
			degrees.add(0);
			nodes.add(null);
		}
		readGraph(fileName);
	}

	private void readGraph(String fileName){
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
				this.numOfVerties = Integer.parseInt(line);
			}

			while((line = reader.readLine()) !=null){
				String [] vertices = line.split("\\s+");
				if(vertices!=null && vertices.length==2){
					insert_edge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]), this.directed);
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


	private void insert_edge(Integer vertex1, Integer vertex2, boolean directed) {
		Node vertex2Obj = new Node(vertex2, 0);

		if(nodes.get(vertex1) != null){
			Node temp = nodes.get(vertex1);
			vertex2Obj.next = temp;
		}
		nodes.set(vertex1, vertex2Obj);
		degrees.set(vertex1, degrees.get(vertex1)+1);

		if(!directed){
			insert_edge(vertex2, vertex1, true);
		} else {
			this.numOfEdges++;
		}
	}
	
	public void printAdjacencyList(){
		for(int i=0; i<this.numOfVerties; i++){
			Node current = nodes.get(i);
			System.out.print( i + "=> Degree: " + this.degrees.get(i) + " => Adjacent are: ");
			while(current!=null){
				System.out.print(current.label + ",");
				current = current.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		Graph g = new Graph("data/graph_data.txt");
		g.printAdjacencyList();
	}
}
