/** 
 * Class definition for a Node of a singly linked list of calculator entries . 
 */
public class NodeCalc {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public int entry;	//the calcultor entry 
	public NodeCalc next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public NodeCalc(int e, NodeCalc n) {
		entry = e;
		next = n;
	}
}