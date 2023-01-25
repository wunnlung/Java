public class StackCalc{

	private NodeCalc head; // maintains the head which is the front of the stack
	private int size; // maintains the size of the stack 

/**
 * Constructor that creates an empty stack
*/
	public StackCalc(){
		head = null;
		size = 0;
	}
/**
* push method which is used to push a new value into the start of the stack
*/
	public void push(int val){
		NodeCalc v = new NodeCalc(val,null);
		v.next = head;
		head = v;
		size++;
	}
/**
* pop method which is used to remove and return the first element of the stack 
*/

	public int pop(){
		int temp = head.entry;
		head = head.next;
		size--;
		return temp;
	}
/**
* peek method which returns the first element of the stack
*/
	public int peek(){
		return head.entry;
	}
/**
* isEmpty method which checks if the stakc is empty or not 
*/
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		else
			return false;
	}
/**
* size method which returns the size of the stack
*/
	public int size(){
		return size;
	}
}
