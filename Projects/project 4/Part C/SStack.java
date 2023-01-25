//chloe and casey project 3
//part A 
//stack class using an array

public class SStack{
	
	private String[] arr;
	private int top = 0;

	public SStack(){
	arr = new String [100];
	}

	public void push(String e){
		arr[top] = e;
		top++;
	}

	public String pop(){
		String temp = arr[top-1];
		top--;
		return temp;
	}

	public String peek(){
		return arr[top-1];
	}

	public boolean isEmpty(){
		return(top == 0);
	}


	public int getSize(){
		return top;
	}
	public static void main(String[] args){
		SStack stringStack = new SStack();
		if(!stringStack.isEmpty() && stringStack.peek().equals(4)){
			System.out.println("hi");
		}
		
	}
}

//end stack class