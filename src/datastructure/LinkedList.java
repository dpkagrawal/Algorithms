package datastructure;

public class LinkedList {
	public class Node {
		Integer data = null;;
		Node next = null;
	}

	Node front, rear;

	LinkedList() {
		this.front = null;
		this.rear = null;
	}

	public void insert(int value) {
		if (front == null) // First value to be inserted into the queue
		{
			front = new Node();
			front.data = value;
			rear = front;
		} else {
			Node new_node = new Node();
			new_node.data = value;
			rear.next = new_node;
			rear = new_node;
		}
	}

	public void display() {
		System.out.println("The values in the queue are ");
		Node current = front;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedList q = new LinkedList();
		System.out
				.println("Please enter how much do you want to insert in the queue");
		// BufferedReader input = new BufferedReader(System.in);
		// Integer count = Integer.parseInt(input.readLine());
		// System.out.println(count);
		q.insert(1);
		q.insert(4);
		q.insert(2);
		q.insert(3);
		q.display();
	}
}
