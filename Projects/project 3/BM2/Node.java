/** 
 * Class definition for a Node of a singly linked list of Characters. 
 */
public class Node {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public Character entry;	//the character entry
	public Node next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public Node(Character e, Node n) {
		entry = e;
		next = n;
	}
}