/**
Stack class
*/
public class Stack{

	private Node head; // maintains the head which is the front of the stack
	private int size; // maintains the size of the stack 
	private Node tail;

/**
 * Constructor that creates an empty stack
*/
	public Stack(){
		head = null;
		tail = null;
		size = 0;
	}

/**
adds a value in the stack
takes in a string, and returns nothing
@param String 
@return  
*/
	public void push(String val){
		Node v = new Node(val,null);
		v.next = head;
		head = v;
		size++;
		if(size==1){
			tail=head;
		}

	}

/**
removes a value fromm the stack
removes the most recent addition to the stack
returns the String that was removed
@param  
@return String
*/
	public String pop(){
		String temp = head.entry;
		head = head.next;
		size--;
		if(size==0){
			tail=null;
		}
		return temp;
	}

/**
removes an object from the start of the stack instead of the top
@param
@param String
*/
	//only need it to dequeue when it has an index of 10
	public String dequeue(){
		Node ret = tail;
		Node temp = head;
		for(int i=0; i<8; i++){
			temp=temp.next;
		}
		tail=temp;
		tail.next=null;
		size--;
		return ret.entry;
	}

/**
returns the top value from the stack 
@param  
@return String object 
*/
	public String peek(){
		return head.entry;
	}

/**
checks if the stack is empty
@param  
@return boolean object 
*/
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		else
			return false;
	}

/**
returns the size of the stack
@param  
@return int object  
*/
	public int getSize(){
		return size;
	}
}

class StackTest{
	public static void main(String[] args) {
		Stack test = new Stack();
		test.push("a");
		test.push("b");
		test.push("c");
		//test.pop();
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
	}
}




