import java.io.*;
import java.util.Scanner;


public class PostFixCalculator{

	public String calculation; //String which is typed in by user to input the algo to be calculated 
	public StackCalc calculator; //the calculator stack to help with postfix calculation 
/*
*The postfix caluclator method which is used to initiate the post fix calculator 
*here calculation is the string and calculator is the new postfix calculator object
*/ 

	public PostFixCalculator(){
		calculation = "";
		calculator = new StackCalc ();
	}
/*
 * calcultor method which does the entire postfix calculation
 * takes in the string that is needed to be calculated as the parameter and then accordingly calculates it 
*/

	public void calculator(String calculation){
		for (int i = 0; i<calculation.length(); i++){

			int num1=0; // initialising the two numbers that need to be operated on
			int num2=0;

			if(Character.isDigit(calculation.charAt(i))){ //taking in all operands 
				int num = Character.getNumericValue(calculation.charAt(i));
				calculator.push(num);
			}
			
			else if(calculation.charAt(i)=='+'){ //checking for operators in the next cases 
				num1 = (calculator.pop());
			 	num2 = (calculator.pop());
				int sum = num1 + num2;
				calculator.push(sum);
			}

			else if(calculation.charAt(i)=='-'){
				num1 = (calculator.pop());
				num2 = (calculator.pop());
				int diff = num2 - num1;
				calculator.push(diff);
			}

			else if(calculation.charAt(i)=='*'){
				num1 = (calculator.pop());
				num2 = (calculator.pop());
				int prod = num1 * num2;
				calculator.push(prod);
			}

			else if(calculation.charAt(i)=='/'){
				num1 = (calculator.pop());
				num2 = (calculator.pop());
				int div = num2 / num1;
				calculator.push(div);
				//System.out.println(calculator.peek());
			}

		}

		System.out.println("The final product of the postfix calculation is " + calculator.pop());
		if(calculator.isEmpty()==false){
			System.out.println("However, it is not correct as you have input an invalid syntax");
			return;
		}
	} 

	// Main method to test if it works

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		PostFixCalculator calc = new PostFixCalculator();
		System.out.println("Enter the postfix algorith to be calcualted:");
		String calculation = scan.next();
		calc.calculator(calculation);
	}
				
}		