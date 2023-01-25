/**Chloe Nguyen - Casy Godfrey
 * COM 212 - Project 3 - Part C - Include Extension for Part E 
 * Post Fix Calculator (accept more than one digit numbers)
 */

import java.util.Scanner;

/**class to create postFix object which will calculate post fix expression */
public class postFix{

	private String[] pemdas; //variable to hold post fix expression as a string array

	private String [] operators = {"*","+","-","/"};
	private DStack mystack = new DStack();

	/**constructor to create a postFix object from user's input
	 * @param s
	 * 		post fix expression from user's input
	 */
	public postFix(String s){
		//split user's input by space 
		pemdas = s.split(" ", -2);

	}

	/**method to do the calculation for the expression
	 * @return double 
	 * 			the result of the expression
	 */
	public double calculate(){
		for( int i=0; i < pemdas.length; i++){
			
			if(!isOperator(pemdas[i])){
				//if it is not an operator, turn it to a double and push to the stack
				double j = Double.parseDouble(pemdas[i]);
				mystack.push(j);
			}
			else{
				//if it is an operator, pop 2 doubles in the stack and do the calculation
				double first = mystack.pop();
				double second = mystack.pop();
				double result = operation(first,second, pemdas[i]);

				//push the result to the stack
				mystack.push(result);
			}
				
		}

		return mystack.peek();
	}
	
	/**method to do the calculation given 2 numbers and the operator
	 * @param f the first number
	 * @param s the second number
	 * @param o the operator
	 * @return the result of the operation
	 */

	private double operation(double f, double s, String o){

		if(o.equals("+")){
			return s + f;
		}
		else if(o.equals("-")){
			return s - f;
		}
		else if(o.equals("*")){
			return s * f;
		}
		else{
			return s / f;
		}
	}

	/**method to check if a character is an operator
	 * @return true if it is an operator
	 * @return false if it is a number
	 */
	private boolean isOperator(String c){
		for(int i = 0; i < operators.length; i++){
			if(c.equals(operators[i])){
				return true;
			}
		}
		return false;
	
	}

}

class postFixCalculator{
	public static void main(String [] args){

		ArithmeticApp test = new ArithmeticApp();
		//String s = "(4*((7+3)+5))";
		//BTree tree = test.buildExpression(s);
		//System.out.println(tree.root.data);
		//String f = "";
		//tree.postOrder(tree.root);
		//System.out.println(tree.fin);


		System.out.println("\n----- Post Fix Calculation App -----");
		System.out.println("Please type your expression in post-fix notation \nSeparate each number/operator by a <Space> \n"
			+ "Type <quit> to quit the program\n");
		Scanner myscanner = new Scanner(System.in);
		String expression;

		do{
			System.out.println("Type your expression in in-fix notation:");
			expression = myscanner.nextLine();
			
			if(expression.equals("quit")){
				break;
			}

			//ArithmeticApp test = new ArithmeticApp();
			BTree tree = test.buildExpression(expression);
			tree.postOrder(tree.root);

			tree.fin.replace("", " ").trim();
			
			System.out.println(tree.fin);
			postFix mypostFix = new postFix(tree.fin);

			System.out.println("Your answer is " + mypostFix.calculate() + " !");
		}while(true);

		System.out.println("\n----- Thank you! See you again! ----- \n");
	}

}