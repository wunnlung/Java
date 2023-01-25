/*
Stack class
*/
public class Stack{

	private Node head; // maintains the head which is the front of the stack
	private int size; // maintains the size of the stack 

/**
 * Constructor that creates an empty stack
*/
	public Stack(){
		head = null;
		size = 0;
	}

/**
adds a value in the stack
takes in a character, and returns nothing
@param Character 
@return  
*/
	public void push(Character val){
		Node v = new Node(val,null);
		v.next = head;
		head = v;
		size++;
	}

/**
removes a value fromm the stack
removes the most recent addition to the stack
returns the character that was removed
@param  
@return Character  
*/
	public Character pop(){
		Character temp = head.entry;
		head = head.next;
		size--;
		return temp;
	}

/**
returns the top value from the stack 
@param  
@return Character object 
*/
	public Character peek(){
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
	public int size(){
		return size;
	}
}

class StackTest{
	public static void main(String[] args) {
		Stack test = new Stack();
		test.push('a');
		test.push('b');
		test.push('c');
		//test.pop();
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
	}
}




