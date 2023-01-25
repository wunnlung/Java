//chloe and casey project 3
//part A 
//stack class using an array

public class DStack{
	
	private double [] arr;
	private int top = 0;

	public DStack(){
	arr = new double [100];
	}

	public void push(double e){
		arr[top] = e;
		top++;
	}

	public double pop(){
		double temp = arr[top-1];
		top--;
		return temp;
	}

	public double peek(){
		return arr[top-1];
	}

	public boolean isEmpty(){
		return(top == 0);
	}


	public int getSize(){
		return top;
	}
}
//end stack class