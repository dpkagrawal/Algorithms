package datastructure;

import java.util.ArrayList;

public class MinHeap {
	
	int sizeOfHeap;
	ArrayList<Integer> values = new ArrayList<Integer>();
	
	MinHeap(int size){
		this.sizeOfHeap = size;
	}
	
	void insert(int value){
		values.add(value);
		heapify();
		
	}
	
	void heapify(){
		int currentSize = values.size() - 1;
		int parent;
		int temp;
		while(currentSize > 0){
			parent = currentSize/2;
			if(values.get(currentSize) <= values.get(parent)){
				temp = values.get(currentSize);
				values.set(currentSize, values.get(parent));
				values.set(parent, temp);


			}
			currentSize = parent;
		}
	}
	
	Integer peak(){
		if(values.size() >0){
			return values.get(0);
		}
		return null;
	}
	
	
	
	public static void main(String[] args){
		MinHeap h = new MinHeap(123);
		h.insert(9);
		System.out.println(h.peak());
		h.insert(2);
		System.out.println(h.peak());
		h.insert(8);
		System.out.println(h.peak());
		h.insert(4);
		System.out.println(h.peak());
		h.insert(2);
		System.out.println(h.peak());
		h.insert(1);
		
		System.out.println(h.peak());
	}
	
}
