//project 4
//Casey and Todd 

/**
 * class for a node specific to binary search trees 
 * each BSTNode has a key a left and right child and a parent 
 * @author casey
 * @author todd 
 */

public class BSTNode{
	int key;
	public BSTNode left;
	public BSTNode right;
	public BSTNode parent;

	/**
	 * method that creates a new BSTNode
	 * @param data an int that the BSTNode holds, the key
	 * @param left a BSTNode that is the left child 
	 * @param left a BSTNode that is the right child 
	 * @param left a BSTNode that is the parent 
	 */

	public BSTNode(int data, BSTNode left, BSTNode right, BSTNode parent){
		key = data;
		left = left;
		right = right;
		parent = parent;

	}

	/**
	 * @return the key of the BSTNode it is enacted on
	 */ 
	
	public int getKey(){
		return key;
	}
}