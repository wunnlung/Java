public class AVL{
	
	public BSTNode root;

	public AVL(){
		root = null;
	}

	/**
	 * getMin returns the minium AVLNode of a subtree
	 * @return BSTNode with smallest value of subtree 
	 */
	public BSTNode getMin(){
		BSTNode temp = root;
		while(true){
			if(temp.left==null){
				return temp;
			}
			temp=temp.left;
		}
	}



	
	public void preOrder(BSTNode v){
		System.out.print(v.key);
		if(v.left != null){
			preOrder(v.left);
		}
		else if(v.right != null){
			preOrder(v.right);
		}
	}


	public void inOrder(BSTNode v){
		if(v.left != null){
			inOrder(v.left);
		}
		System.out.println(v.key);
		if(v.right != null){
			inOrder(v.right);
		}
	}
	

	public void postOrder(BSTNode v){
		if(v.left != null){
			postOrder(v.left);
		}
		if(v.right != null){
			postOrder(v.right);
		}
		System.out.println(v.key);
	}

}