package datastructure;
/*
 * 
 * This Java program is to implement Min heap. A Heap data structure is a Tree based data structure
 *  that satisfies the HEAP Property “If A is a parent node of B then key(A) is ordered with respect 
 *  to key(B) with the same ordering applying across the heap.”
 *	So in a Min Heap this property will be “If A is a parent node of B then key(A) is 
 *  less than key(B) with the same ordering applying across the heap.” and
 *   in a max heap the key(A) will be greater than Key(B).
 *   
 *   https://en.wikipedia.org/wiki/Heap_(data_structure)
 * 
 */
public class MinHeap {
	int[] heap;
	int size;
	int max_size;
	private static final int FRONT = 1;

	MinHeap(int size) {
		heap = new int[size + 1];
		this.size = 0;
		this.max_size = size;
		heap[0] = Integer.MIN_VALUE;
	}

	int parent(int pos) {
		return pos / 2;
	}

	int leftChild(int pos) {
		return 2 * pos;
	}

	int rightChild(int pos) {
		return 2 * pos + 1;
	}

	boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	boolean isEmpty() {
		return this.size == 0;
	}

	void swap(int pos1, int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}

	void insert(int value) {
		if (size <= max_size) {
			size = size +1;
			heap[size] = value;
			int currentIndex = size;
			while (heap[currentIndex] < heap[parent(currentIndex)]) {
				swap(currentIndex, parent(currentIndex));
				currentIndex = parent(currentIndex);
			}
		} else {
			System.out.println("MAXIMUM SIZE REACHED");
		}
	}

	Integer getMin() {
		Integer returnValue = null;
		if (!isEmpty()) {
			returnValue = heap[FRONT];
			heap[FRONT] = heap[size];
			size--;
			minHeapify(FRONT);
		}
		return returnValue;
	}

	void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (heap[pos] > heap[leftChild(pos)]
					|| heap[pos] > heap[rightChild(pos)]) {
				if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : "
					+ heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
			System.out.println();
		}
	}

	public static void main(String... arg) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.print();
		System.out.println("Min Value:" + minHeap.getMin());
		minHeap.print();
		System.out.println("The Min val is " + minHeap.getMin());
	}
}
