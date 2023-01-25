//post order (L R P) of fig 8.6
//3 1 + 3 * 9 5 - 2 + / 3 7 4 - * 6 + - 

/**
 * class that creates a Tree node
 * methods include getKey
 * @author casey
 * @author todd
 */
public class TNode{
	public char data;
	public TNode left;
	public TNode right;

	/**
	 * constructor for TNode class
	 */
	public TNode(char data, TNode l, TNode r){
		data = data;
		left = l;
		right = r;
	}

	/**
	 * getKey returns the character stored in data
	 * @param
	 * @return char
	 */
	public char getKey(){
		return data;
	}
}