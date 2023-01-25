//project 4
//casey and todd



import java.util.*;  // for built-in Stack class

/**
 * class that creates a binary search tree 
 * methods include getMin, find, delete, replace, insert, post order, pre order, 
 * and inorder
 * @author casey
 * @author todd
 */

public class BST{


	public BSTNode root;
	public BSTNode right;
	public BSTNode left;
	public int value;

	/** constructor for bianry search tree class
	 * creates an empty binary search tree
	 */

	public BST(){
		root = null;
		right = null;
		left = null;
		value = 0;
	}

	/**
	 * getMin returns the minium BSTNode of a sudbtree
	 * @param v is  BSTNode that is the root of 
	 * the subtree that the method searches through
	 * @return BSTNode with smallest value of subtree 
	 */

	public BSTNode getMin(BSTNode v){
		BSTNode temp = v;
		while(true){
			if(temp.left==null){
				return temp;
			}
			temp=temp.left;
		}
	}

	/** find finds a BSTNode within the BST with a certain key value
	 * @param k is the int wanting to be found
	 * @param v is the BSTNode being compared to the wanted value\
	 * @return BSTNode with matching key value
	 */

	public BSTNode find(int k, BSTNode v){
		if(v == null){
			return null;
		}
		else if(v.key > k){
			return find(k, v.left);
		}
		else if(v.key < k){
			return find(k, v.right);
		}
		else{
			return v;
		}
	}

	/**
	 * deletes the BSTNode from the tree with the value given
	 * @param k is an int that is to be deleted from the BST
	 * @return the BSTNode matching value being searched for 
	 * first calls find to find the BSTNode with the matcking int k
	 * replaces v with different BSTNode 
	 */

	public BSTNode delete(int k){
		BSTNode v = find(k,root);
		if(v!=null){
			if(root==null){
				return null;
			}
			if(v.left==null && v.right==null){
				if(v==root){
					root=null;
				}else if(v.parent.right==v){
					v.parent.right=null;
				}else{
					v.parent.left=null;
				}
			}
			else if(v.left!=null && v.right!=null){
				BSTNode s=getMin(v.right);
				v.key=s.key;
				replace(s,s.right);
			}
			else if(v.left!=null || v.right!=null){
				if(v.left!=null){
					replace(v,v.left);
				}
				else{
					replace(v,v.right);
				}
			}
			return v;
		}
		else{
			return null;
		}
	}

	/** 
	 * replaces a BSTNode with another BSTNode
	 * @param v is the BSTNode to be replaced 
	 * @param w is the BSTNode doing the replacing
	 */

	public void replace(BSTNode v, BSTNode w){
		if(v.key==root.key){
			root=w;
		}
		else if(v.parent.right.key==v.key){
			v.parent.right=w;
		}
		else{
			v.parent.left=w;
		}
	}

	/** 
	 * inserts a new BSTNode into correct spot in BST
	 * keeping the BST structure in tact 
	 * smaller to the left bigger values right
	 * @param k is the key value of the BSTNode being inserted 
	 * @param v is the BSTNod being inserted
	 * called within a secondary insert to streamline code
	 */
	
	private void recInsert(int k, BSTNode v){
		if(k > v.key){
			if(v.right != null){
				recInsert(k, v.right);
			}
			else{
				v.right = new BSTNode(k,null,null,v);
				BSTNode temp = v.right;
				temp.parent = v;
			}
		}
		else if(k <= v.key){
			if(v.left != null){
				recInsert(k,v.left);
			}
			else{
				v.left = new BSTNode(k,null,null,v);
				BSTNode temp = v.left;
				temp.parent = v;
			}
		}
	}

	/**
	 * inserts a BSTNode into tree
	 * @param k is the key value of the new BSTNode 
	 * if the tree is empty the new node becomes the root
	 * if the tree is nt empty recInsert is called
	 * and the new BSTNode is entered keeing BST 
	 */

	public void insert(int k){
		if(root == null){
			root = new BSTNode(k,null,null,null);
		}
		else{
			recInsert(k,root);
		}

	}

	/**
	 * prints out keys of BSTNodes in BST
	 * prints out the key of each node when ecountered 
	 * then goes left till left is null
	 * then goes right till right is null
	 * @param v the BSTNode wanted to start traversing
	 */

	public void preOrder(BSTNode v){
		System.out.print(v.key);
		if(v.left != null){
			preOrder(v.left);
		}
		else if(v.right != null){
			preOrder(v.right);
		}
	}

	/**
	 * prints out keys of BSTNodes in BST
	 * goes left until null 
	 * prints out key of BSTNode
	 * then goes right until null 
	 * @param v the BSTNode wanted to start traversing the BST at
	 */

	public void inOrder(BSTNode v){
		if(v.left != null){
			inOrder(v.left);
		}
		System.out.println(v.key);
		if(v.right != null){
			inOrder(v.right);
		}
	}
	/**
	 * prints out keys of BSTNodes in BST
	 * goes left until null
	 * then right until null
	 * then prints out key of BSTNode
	 * @param v the BSTNode wanted to start traversing the BST at
	 */

	public void postOrder(BSTNode v){
		if(v.left != null){
			postOrder(v.left);
		}
		if(v.right != null){
			postOrder(v.right);
		}
		System.out.println(v.key);
	}

	/**
	 * method that invokes post, in, and preorder
	 *  @param traverseType is the order type the BST is to be printed in
	 */

	public void traverse(char traverseType){
		switch(traverseType)
		{
			case 'p': System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
			case 'i': System.out.print("\nInorder traversal:  ");
				inOrder(root);
				break;
			case 't': System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println();
	}

	/**
	 * method thay displays a visual BST
	 */

	public void displayTree(){
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				BSTNode temp = (BSTNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  
		System.out.println(
		"......................................................");
	}  

}
 

/**
 * class including main method that tests BST class
 */

class BSTest{
	public static void main(String[] args) {
		BST test = new BST();
		test.insert(10);
		test.insert(9);
		test.insert(7);
		test.insert(5);
		test.insert(6);
		test.insert(8);
		test.insert(11);
		
		test.inOrder(test.root);
		System.out.println("");
		//test.delete(9);
		test.postOrder(test.root);
		test.displayTree();
	}
}












