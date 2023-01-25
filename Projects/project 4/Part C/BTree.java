/**
 * class that creates a binary search tree 
 * methods include getRoot, addRoot, attach, and postOrder
 * @author casey
 * @author todd
 */
public class BTree{
	public TNode root;
	public TNode left;
	public TNode right;
	public String fin;

	/** constructor for bianry search tree class
	 * creates an empty binary search tree
	 */ 
	public BTree(){
		fin="";
	}

	/**
	 * getRoot returns the root of the tree
	 * @param
	 * @return char
	 */
	public char getRoot(){
		return root.getKey();
	}

	/**
	 * addRoot returns adds a root to the binary tree
	 * @param r a TNode
	 * @return
	 */
	public void addRoot(TNode r){
		root = r;

	}

	/**
	 * attach attaches two trees as children of another tree
	 * @param p a BTree
	 * @param l a BTree
	 * @param r a BTree
	 * return BTree
	 */
	public BTree attach(BTree p, BTree l, BTree r){
		if(p.root.left == null && p.root.right == null){
			//System.out.println(l.root);
			//TNode v = new TNode(l.getRoot(), null,null);
			//TNode b = new TNode(r.getRoot(), null,null);
			p.root.left = l.root;
			//System.out.println(p.left.getKey());
			p.root.right = r.root;
			//System.out.println(p.right.getKey());
			l = null;
			r = null;
		}
		return p;
	}

	/**
	 * postOrder prints out the tree in postOrder
	 * @param v a TNode
	 * @return
	 */
	public void postOrder(TNode v){
		//System.out.println(v.getKey());
		if(v.left != null){
			//System.out.println("test1");
			postOrder(v.left);
		}
		if(v.right != null){
			//System.out.println("test2");
			postOrder(v.right);
		}
		//System.out.print(v.getKey());
		fin+=v.getKey();
		//fin+=" ";
	}
}