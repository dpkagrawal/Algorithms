package datastructure;
import java.util.HashMap;
import java.util.Map;

class Trie {
	class Node {
		Map<Character, Node> children = new HashMap<Character, Node>();
		char data;
		boolean isWord;
		int count = 0;

		Node() {
		}

		Node(char data) {
			this.data = data;
		}
	}

	Node root = null;

	Trie() {
		root = new Node();
	}

	public void insert(String input) {
		if (input == null || input.length() == 0)
			return;
		Node current = root;
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			// int charIndex = (int) currChar;
			if (current.children.containsKey(currChar)) { // Character Exists
				current = current.children.get(currChar);
			} else {
				Node newNode = new Node(currChar);
				current.children.put(currChar, newNode);
				current = newNode;
			}
			current.count++;
			if (i == input.length() - 1) {
				current.isWord = true;
			}
		}
	}

	public boolean findExact(String input) {
		Node found = findNode(input);
		if (found != null && found.isWord) {
			return true;
		}
		return false;
	}

	public boolean findPrefix(String input) {
		Node found = findNode(input);
		if (found != null)
			return true;
		return false;
	}

	public Node findNode(String input) {
		if (input == null || input.length() == 0)
			return null;
		Node current = root;
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			if (current.children.containsKey(currChar)) {
				current = current.children.get(currChar);
			} else {
				return null;
			}
		}
		return current;
	}

	public void delete(String input) {
		if (input == null || input.length() == 0)
			return;
		deleteNode(root, input, 0);
	}

	/*
	 *  Recursive version of delete, where we dont keep track of count.
	 *  We go till the last character of the string, if it does not have any children
	 *  We return true, and at previous step delete the char.
	 *  
	 *  The recursion we bubble up to the root, and each step will delete if no child.
	 */
	public boolean deleteNode(Node curr, String input, int index) {
		if (index == input.length()) {
			curr.isWord = false;
			return curr.children.isEmpty();
		}
		char currChar = input.charAt(index);
		if (curr.children.containsKey(currChar)) {
			Node child = curr.children.get(currChar);
			boolean delete = deleteNode(child, input, index + 1);
			if (delete) {
				curr.children.remove(currChar);
			}
			return delete && curr.children.isEmpty();
		} else {
			System.out.println("Does not contain in trie : " + input);
			return false;
		}
	}

	/*
	 * If we are keeping track of count for each node, of how many elements are
	 * present below. if count==1, we can remove the node/char. else we
	 * decrement the count.
	 */
	public void deleteUsingCount(String input) {
		Node current = root;
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			if (current.children.containsKey(currChar)) {
				Node child = current.children.get(currChar);
				if (child.count == 1) {
					current.children.remove(currChar);
					return;
				} else {
					child.count--;
					current = child;
				}
			} else {
				System.out.println("Does not contain in trie : " + input);
				break;
			}
		}
		current.isWord = false;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("hello");
		t.insert("hello world");
		t.insert("uber");
		t.insert("up");
		System.out.println("\nDoes exact query: uber. exist? " + t.findExact("uber"));
		System.out.println("Does exact query: hello. exist? " + t.findExact("hello"));
		System.out.println("Does prefix query: hello. exist? "+ t.findPrefix("hello"));
		System.out.println("\nDeleting : hello");
		t.delete("hello");
		System.out.println("Does exact query: hello. exist? " + t.findExact("hello"));
		System.out.println("Does prefix query: hello. exist? " + t.findPrefix("hello"));
		System.out.println("Does exact query: uber. exist? " + t.findExact("uber"));
		System.out.println("\nDeleting : uber");
		t.delete("uber");
		System.out.println("Does exact query: uber. exist? " + t.findExact("uber"));
		System.out.println("Does exact query: up. exist? " + t.findExact("up"));
		System.out.println("\nDeleting (not exist) : world ");
		t.delete("world");
		

		
		System.out.println("\nDoes exact query: up. exist? " + t.findExact("up"));
		System.out.println("\nDeleting : up");
		t.delete("up");
		System.out.println("Does exact query: up. exist? " + t.findExact("up"));
		System.out.println("Does prefix query: u. exist? " + t.findExact("u"));
	}
}