/*
Stack class
*/
public class Stack{

	public Node head; // maintains the head which is the front of the stack
	public int size; // maintains the size of the stack 

/**
 * Constructor that creates an empty stack
*/
	public Stack(){
		head = null;
		size = 0;
	}

/**
adds a value in the stack
takes in a Node, and returns nothing
@param Node 
@return  
*/
	public void push(BTree val){
		Node v = new Node(val,null);
		v.next = head;
		head = v;
		size++;
	}

/**
removes a value fromm the stack
removes the most recent addition to the stack
returns the Node that was removed
@param  
@return Node  
*/
	public BTree pop(){
		BTree temp = head.entry;
		head = head.next;
		size--;
		return temp;
	}

/**
returns the top value from the stack 
@param  
@return Node object 
*/
	public BTree peek(){
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
		BTree t1 = new BTree();
		TNode n = new TNode('a', null,null);
		t1.addRoot(n);
		test.push(t1);
		BTree h = test.peek();
		//h.postOrder(n);
		//System.out.println();
		/*
		Stack test = new Stack();
		test.push('a');
		test.push('b');
		test.push('c');
		//test.pop();
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
		*/
	}
}




