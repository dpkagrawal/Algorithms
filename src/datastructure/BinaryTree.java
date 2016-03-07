package datastructure;

// http://cslibrary.stanford.edu/110/BinaryTrees.html
// https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
public class BinaryTree {
	public class Node {
		public int data;
		Node left;
		Node right;

		Node() {
			left = null;
			right = null;
		}
	}

	private Node root = null;

	public void insert(int value) {
		root = insert(this.root, value);
	}

	public Node insert(Node root, int value) {
		if (root == null) {
			Node n = new Node();
			n.data = value;
			return n;
		}
		if (value < root.data)
			root.left = insert(root.left, value);
		else
			root.right = insert(root.right, value);
		return root;
	}

	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}

	private static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public boolean find(Integer value) {
		Node searchedNode = find(root, value);
		if (searchedNode != null) {
			return true;
		}
		return false;
	}

	private Node find(Node currNode, Integer value) {
		if (currNode != null) {
			if (currNode.data == value)
				return currNode;
			else if (value < currNode.data)
				return find(currNode.left, value);
			else
				return find(currNode.right, value);
		}
		return null;
	}

	public void nearestCommonAncestor(Integer p, Integer q) {
		if (find(p) && find(q)) {
			Node ancestor = nearestCommonAncestor(root, p, q);
			if (ancestor != null) {
				System.out.println("ANCESTOR Is: " + ancestor.data);
			}
		} else{
			System.out.println("ANCESTOR NOT FOUND ");
		}
	}

	private Node nearestCommonAncestor(Node currNode, Integer p, Integer q) {
		if (currNode != null) {
			if (p < currNode.data && q < currNode.data) {
				return nearestCommonAncestor(currNode.left, p, q);
			} else if (p > currNode.data && q > currNode.data) {
				return nearestCommonAncestor(currNode.right, p, q);
			} else {
				return currNode;
			}
		}
		return null;
	}
	
	public void delete(Integer value){
		root = delete(root, value);
	}
	
	private Node delete(Node currNode,Integer value){
		if (currNode != null) {
			
			if(value < currNode.data){ 
				currNode.left = delete(currNode.left, value);
			} else if( value > currNode.data){
				currNode.right = delete(currNode.right, value);
			} else if(currNode.left!=null && currNode.right!=null){
				currNode.data = findMin(currNode.right).data;
				currNode.right = delete(currNode.right, currNode.data);
			} else{
				return currNode.left!=null ? currNode.left : currNode.right;
			}
		}
		return currNode;
	}
	
	private Node findMin(Node node){
		if(node==null)
			return null;
		else if(node.left==null){
			return  node;
		} else{
			return findMin(node.left);
		}
	}

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.insert(7);
		b.insert(9);
		b.insert(5);
		b.insert(2);
		b.insert(1);
		b.insert(8);
		b.insert(4);
		b.insert(3);
		b.inOrder();
		b.preOrder();
		b.postOrder();
		System.out.println(b.find(8));
		System.out.println(b.find(10));
		b.nearestCommonAncestor(3, 6);
		b.nearestCommonAncestor(3, 9);
		b.nearestCommonAncestor(1, 2);
		
		
		System.out.println("DELETED");
		b.delete(7);
		b.delete(9);
		b.delete(5);
		b.delete(2);
		b.delete(1);
		b.delete(8);
		b.delete(4);
		b.delete(3);
		b.inOrder();

		System.out.println("SECOND TREE: ");
		BinaryTree b1 = new BinaryTree();
		b1.insert(7);
		b1.inOrder();
		b1.delete(7);
		b1.inOrder();
	}
	
}
