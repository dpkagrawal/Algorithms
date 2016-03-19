package datastructure;

import java.util.Stack;
import datastructure.BinaryTree.Node;

public class BSTIterator {
	Stack<Node> stackNodes = new Stack<Node>();

	// Set<TreeNode> visited = new HashSet<TreeNode>();
	public BSTIterator(Node root) {
		while (root != null) {
			stackNodes.push(root);
			// visited.add(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stackNodes.empty();
	}

	/** @return the next smallest number */
	public int next() {
		Node top = stackNodes.pop();
		Node temp = top.right;
		while (temp != null) {
			stackNodes.add(temp);
			temp = temp.left;
		}
		return top.data;
	}
}