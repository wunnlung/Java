/**Chloe Nguyen - Casy Godfrey
 * COM 212 - Project 3 - Bonus 1
 * In Fix Expression Calculator
 */

import java.util.Scanner;

/**class to create inFix object which will calculate in fix expression */
public class inFix{

	private String[] pemdas; //variable to hold in fix expression as a string array

	private String [] operatorsList = {"*","+","-","/"};

	private DStack operands = new DStack(); //stack to hold operands
	private SStack operators = new SStack(); //stack to hold operators

	/**constructor to create a postFix object from user's input
	 * @param s
	 * 		post fix expression from user's input
	 */
	public inFix(String s){
		//split user's input by space 
		pemdas = s.split(" ", -2);

	}

	/**method to do the calculation for the in fix expression
	 * @return double 
	 * 			the result of the expression
	 */
	public double calculate(){
		for( int i=0; i < pemdas.length; i++){
			
			if(!isOperator(pemdas[i])){
				//if it is not an operator, turn it to a double and push to the stack
				double j = Double.parseDouble(pemdas[i]);
				operands.push(j);
			}
			else{

				if(!operators.isEmpty() && !isPrecedence(operators.peek(), pemdas[i])){
					/*if it is an operator, and it is not precedent the previous operator in the stack
					pop 2 doubles in the stack and pop 1 operator to do the calculation */
					double first = operands.pop();
					double second = operands.pop();
					double result = operation(first,second, operators.pop());

					//add the new operator to the operator stack
					operators.push(pemdas[i]);

					//push the result to the operands stack
					operands.push(result);
				}
				else{
					operators.push(pemdas[i]);
				}
			}
				
		}

		//if the operators stack is not empty yet
		while(!operators.isEmpty()){

			/*pop two doubles in the operands stack and 1 operator in the operator stack
			to do the calculation until there is no more operator*/
			double first = operands.pop();
			double second = operands.pop();
			String operator = operators.pop();
			double result = operation(first,second, operator);
			operands.push(result);
		}

		return operands.peek();
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
		for(int i = 0; i < operatorsList.length; i++){
			if(c.equals(operatorsList[i])){
				return true;
			}
		}
		return false;
	
	}

	/** method two check if one operator has higher precedence than the other
	 * @param o1 the first operator
	 * @param 02 the second operator
	 * @return true if o2 has higher precedence than o1
	 * @return false otherwise
	 */

	private boolean isPrecedence(String o1, String o2){
		if((o1.equals("+") || o1.equals("-"))&&(o2.equals("*") || o2.equals("/"))){
			return true;
		}
		else{
			return false;
		}
	}

} //end of class inFix

class inFixCalculator{
	public static void main(String [] args){
		System.out.println("\n----- In Fix Calculation App -----");
		System.out.println("Please type your expression in in-fix notation \nSeparate each number/operator by a <Space> \n"
			+ "Type <quit> to quit the program\n");
		Scanner myscanner = new Scanner(System.in);
		String expression;

		do{
			System.out.println("Type your expression in postfix notation:");
			expression = myscanner.nextLine();
			
			if(expression.equals("quit")){
				break; //break the loop when the user types quit
			}
			inFix mypostFix = new inFix(expression);
			System.out.println("Your answer is " + mypostFix.calculate() + " !");
		}while(true);

		System.out.println("\n----- Thank you! See you again! ----- \n");
	}

}