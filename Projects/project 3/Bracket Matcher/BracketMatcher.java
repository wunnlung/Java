/*
Class for the bracket matcher
*/
import java.io.*;
import java.util.Scanner;

public class BracketMatcher{

	public Character[] openBrackets = {'(', '[', '{', '<'};
	public Character[] closedBrackets = {')', ']', '}', '>'};

	//constructor
	public BracketMatcher(){
		openBrackets = openBrackets;
		closedBrackets = closedBrackets;

	}

	/*
	opening bracket function
	takes in a character and returns true if its an opening bracket
	false if it is not
	*/
	public Boolean isOpeningBracket(Character c){
		for(Character i: openBrackets){
			if(c==i){
				return true;
			}
		}
		return false;
	}

	/*
	closing bracket function
	checks if bracket is a closing bracket and returns true if it is
	false if anything else
	*/
	public Boolean isClosingBracket(Character c){
		for(Character i: closedBrackets){
			if(c==i){
				return true;
			}
		}
		return false;
	}

	/*
	bracket matcher check
	input two brackets and check if they are matching open/close brackets
	retrun true if they are, false if not
	*/
	public Boolean corresponds(char open, char close){
		//keeps track of the indexes
		int i1 = 0;
		int i2 = 0;
		//to get the index of the opening bracket
		for(Character b1: openBrackets){
			if(open==b1){
				//exit the for loop
				break;
			}
			//incrase the index
			i1++;
		}

		for(Character b2: closedBrackets){
			if(close==b2){
				break;
			}
			i2++;
		}

		//if the indexes are the same
		if(i1==i2){
			return true;
		}else{
			return false;
		}
	}


	/*
	input a string, checks if all of the brackets match
	return true if they do, false if brackets aren't matched
	*/
	public boolean checkBrackets(String s){
		//cool method I found on google
		char[] chList = s.toCharArray();
		//create a stack for stacking characters
		Stack chStack = new Stack();
		//for characters in character list:
		for(char ch: chList){
			//if the character is an opening bracket
			if(isOpeningBracket(ch)==true){
				//push it into the stack
				chStack.push(ch);
			}
			//if the character is a closing bracket
			if(isClosingBracket(ch)==true){
				//first case is if stack is empty
				if(chStack.isEmpty()==true){
					//immediately return false, as there are no matching
					//opening brackets
					return false;
				}
				//otherwise, we want to check if its matching
				//get the top character
				char head = chStack.peek();
				//check if they correspond
				if(corresponds(head, ch)==true){
					//then it corresponds, and we want to pop the head
					char pop = chStack.pop();
				}else{
					//if it doesn't correspond, return false immediately
					return false;
				}
			}
		}
		//last case: if any opening brackets left
		if(chStack.isEmpty()==false){
			//then return false
			return false;
		}
		//otherwise just return true at the end
		return true;
	}


}

/*
test class for the bracket matcher
*/
class BracketMatchApp{
	public static void main(String[] args) {
		//testers
		Scanner scan = new Scanner(System.in);
		BracketMatcher b = new BracketMatcher();
		
		/* System.out.println(b.isOpeningBracket('('));
		System.out.println(b.isOpeningBracket(')'));
		System.out.println(b.isClosingBracket('('));
		System.out.println(b.isClosingBracket(')'));
		System.out.println(b.corresponds('[', ']')); */

		System.out.println("Enter a string with brackets for bracket match:");
		String inp = scan.next();
		String test = "<";
		System.out.println(b.checkBrackets(inp));
		


	}
}



















