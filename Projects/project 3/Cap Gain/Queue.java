/**
this is the Queue class
it uses nodes of Stock objects
*/
public class Queue{

	public sNode head; //maintains the head of the queue 
	public sNode tail; //maintains the tail of the queue 
	public int size; //maintains the size of the queue

/** 
* Constructor that creates an empty list 
*/ 
	public Queue(){
		head = null;
		tail = null;
		size=0;
	}
/**
* Method that enqueues the values at the end of the LL
*/

	public void enqueue(Stock val){
		sNode temp = new sNode(val, null);
		if(size==0){
			head=temp;
			tail=head;
			size++;
			return;
		}
		tail.next = temp;
		tail = tail.next;
		size++;
	}
/**
* Method that removes and returns the value which is at the start of the LL 
*/

	public Stock dequeue(){
		sNode temp = head;
		head = head.next;
		size--;
		if(size==0)
			tail = null;
		return temp.entry;
	}
/**
* Method that returns the value that is at the front of the LL
*/

	public Stock front(){
		return head.entry;
	}
/**
* Method that returns a boolean to show if the LL is empty or not 
*/

	public boolean isEmpty(){
		return (size==0);
	}

/**
* Method that returns the size of the LL
*/

	public int size(){
		return size;
	}

/**
this function prints out the Queue as a string
@param
@return
*/
	public void printString() { 
		sNode temp = head;
		for(int i=0; i<size; i++){
			System.out.println(temp.entry);
			temp=temp.next;
		}
		//return "(" + shares + ", " + price + ")"; 
	}

/**
returns the total shares of the objects in the queue
@param
@return int object
*/
	public int totalShares(){
		sNode temp = head;
		int total = 0;
		for(int i=0; i<size; i++){
			total+=temp.entry.getShares();
			temp=temp.next;
		}
		return total;
	}
}

/**
this class is used to test that the Queue runs properly
*/
class QueueTest{
	public static void main(String[] args) {
		Stock a = new Stock(1,100);
		Stock b = new Stock(2,200);
		Stock c = new Stock(3,300);
		Queue test = new Queue();
		test.enqueue(a);
		test.enqueue(b);
		test.enqueue(c);
		//test.pop();
		test.printString();
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
	}
}





