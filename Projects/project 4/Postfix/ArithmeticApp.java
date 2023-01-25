
import java.util.*;  // for built-in Stack class

/**
 * class that creates an arithmetic app 
 * methods include build expression
 * @author casey
 * @author todd
 */

public class ArithmeticApp{

	private Stack trees;

	/**
	 * constructor for Arithmetic App class
	 */

	public ArithmeticApp(){
		trees = new Stack();
	}

	/**
	 * buildExpression returns the final BTree that is the infix notation
	 * of the inputted string
	 * @param s is the String that the user inputs
	 * @return BTree
	 */
	public BTree buildExpression(String s){
		char[] chars = s.toCharArray();
		//BTree temp1;
		//BTree temp2;
		//BTree temp3;
		for(int i = 0; i < chars.length; i ++){
			if(chars[i] != ')' && chars[i] != '('){
				TNode p = new TNode(chars[i], null,null);
				p.data = chars[i];
				BTree t = new BTree();
				t.addRoot(p);
				trees.push(t);	
			}

			else if (chars[i] == ')'){
				BTree temp1;
				BTree temp2;
				BTree temp3;
				/*
				if(trees.isEmpty()!=true){
					temp1 = trees.pop();
					System.out.println("hey");
				}
				else if(trees.isEmpty()){
					temp1 = null;
					System.out.println("t1");
				}
				if(trees.isEmpty()!=true){
					temp2 = trees.pop();
					System.out.println("hey2");
				}
				else if(trees.isEmpty()){
					temp2 = null;
					System.out.println("t2");
				}
				if(trees.isEmpty()!=true){
					temp3 = trees.pop();
					System.out.println("hey3");
				}
				else if(trees.isEmpty()){
					temp3 = null;
					System.out.println("t3");
				}
				*/
				temp1 = trees.pop();
				temp2 = trees.pop();
				temp3 = trees.pop();
				BTree l = temp1.attach(temp2, temp3, temp1);
				trees.push(l);


			}
		}
		/*
		while(trees.head.next!= null){
			trees.head.entry.postOrder(trees.head.entry.root);
			trees.head=trees.head.next;
		}
		*/
		BTree fin = trees.pop();
		//fin.postOrder(fin.root);
		//System.out.println(fin.left.data);
		return fin;
	}

	




}
// end class bulid expression

class Arithmetic{
	public static void main(String[] args) {
		ArithmeticApp test = new ArithmeticApp();
		String s = "(4*((7+3)+5))";
		BTree tree = test.buildExpression(s);
		//System.out.println(tree.root.data);
		tree.postOrder(tree.root);
		System.out.println("");
	}
}