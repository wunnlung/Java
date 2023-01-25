/** 
 * Class definition for a Node of a singly linked list of Stock objects. 
 */
public class sNode {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public Stock entry;	//the Stock entry
	public sNode next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public sNode(Stock e, sNode n) {
		entry = e;
		next = n;
	}
}