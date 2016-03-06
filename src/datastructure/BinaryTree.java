package datastructure;
import java.util.HashMap;
import java.util.Map;


public class BinaryTree{
	
	Map parents = new HashMap<Integer,Integer>();
	public class Node{
	public int data;
	Node left;
	Node right;


	Node()
	{
			
		left  = null;	
		right = null;

	}
	}
	Node root=null;
	

	public  void insert( int value)

	{
		Node current = root;
		Node previous=null;

		if(root==null )
		{
			System.out.println("jdsfad");
			root = new Node();
			root.data = value;
			//root = current;
		}

		else
		{
		
			while(current!=null)

			{
				previous = current;
				if(current.data<value)
				{	
					current = current.left;
				}
				else
				{	
										
					current = current.right;
				}
			}
			
			Node newnode=new Node();
			newnode.data=value;
			if(previous.data<value)
				previous.left = newnode;
			else
				previous.right=newnode;
		
		}
	
	}

	public static void inorder( Node root)
	{
		if( root==null)
			return;

		else
		{
			inorder(root.left);		
			System.out.println(root.data);
			inorder(root.right);

		
		}
	
	}




/*	public Boolean delete(int value)
	{
		if(this.root==null)
			return false;
		else
		{


			Node current = this.root;
			Node parentNode;
			
			while(current!=null)

			{
				if(value<current.data)
					{
						parentNode = current;
						current=current.left;	

					}
				else if ( value> current.data)
				{
					parentNode = current;
					current=current.right;
				}			
				else if( value =current.data)
					break;			

			}
						
			Node deleteNode=current;
			
			if(deleteNode.left== null && deleteNode.right==null)
			{
				if(parentNode.left.data ==value)

					parentNode.left=null;
				else
					parentNode.right=null;
				free(deleteNode);

			}
			else if (deleteNode.left!=null || deleteNode.right!=null)

			{
				if(parentNode.left.data ==value)

					parentNode.left=deleteNode.left;
				else
					parentNode.right=deleteNode.right;
				free(deleteNode);

			}
			else (deleteNode.left!=null && deleteNode.right!=null)

			{
				Node inorderSuccessor=deleteNode.right;// = findInorderSuccessor();
				
				while(inorderSuccessor.left!=null)
					inorderSuccessor = inorderSuccessor.left;

				deleteNode.data =inorderSuccessor.data;
				
				


			}
			
			

		}



	}
*/

public Boolean findParents(Node p )
{
Node current = this.root;
		
		while(current.data != p.data)
		{		

			this.parents.put(current,current.data);
			


			if(p.data< current.data)
				current=current.left;
			else
				current=current.right;
			
		}
		
		if(current!=null)
			return true;
		else
			return false;
	


}
public void nearestCommonAncestor(Integer p , Integer q)

{
	Node current = this.root;
	if(this.root.left==null && this.root.right==null)
		System.out.println("There is only a root node");	
		
	//else if(!findParents(p) || !findParents(p))
	//	System.out.println("Cannot find the given nodes");
	else {

		
		while(current.data != p )
		{		
			this.parents.put(current.data,0);
			System.out.println("inserting "+current.data+"value of p"+p);
			if(current.data<p)
				current=current.left;
			else
				current=current.right;

			if(current==null)break;
			
		}

		current=this.root;
		while(current.data != q )
		{		System.out.println("hello3");
			if(parents.containsKey(current.data))
			{
				Integer i = (Integer)this.parents.get(current.data);
				System.out.println("the value is : "+current.data);
				//parents.put(current.data,i++);
			}
			else
				this.parents.put(current.data,0);
			if( current.data<q)
				current=current.left;
			else
				current=current.right;
			if(current==null)break;
			
		}

		for(Object key : parents.keySet())
		{
			Integer value = (Integer)parents.get(key);
			System.out.println("the list contains "+value+"dfadf"+key);

		}
		


	}

		

		/*for(MapEntry mapEntry : parents.entrySet()) {
	    		Node key = mapEntry.getKey();
	   		 Integer value = mapEntry.getValue();
		}*/


}



	public static void main( String[] args)
	{

		BinaryTree b = new BinaryTree();
		 b.insert(7);
		b.insert(9);
		b.insert(5);
		
		b.insert(2);
		b.insert(1);
		b.insert(8);



		inorder(b.root);
		b.nearestCommonAncestor(2,1);
	

	}



}
