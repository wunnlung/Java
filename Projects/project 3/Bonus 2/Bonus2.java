/**
Class that manages the UI for the bonus #2, which is the redo thing
*/

import java.util.Scanner;

public class Bonus2{
	public static void main(String[] args) {
		//create new stack for the undo history
		Stack s = new Stack();
		//craete new redo stack
		Stack redo = new Stack();
		//scanner for input
		Scanner scan = new Scanner(System.in);
		//create the user input string
		String inp;
		//do loop
		do{
			//String
			System.out.println("");
			System.out.print("Type edit command> ");
			//user input
			inp = scan.next();
			//if the user enters in "undo"
			if(inp.equals("undo")){
				//then there are two options
				//first, if undo history is empty
				if(s.isEmpty()==true){
					//print out "no more edits to undo"
					System.out.println("result > no more edits left in undo history");
				//otherwise,
				}else{
					//undo the last action
					String undo = s.pop();
					//add it to the redo stack
					redo.push(undo);
					System.out.println("result > undone "+undo+" command");
				}
			//if the user quits,	
			}else if(inp.equals("quit")){
				//print out quit
				//will quit on it's own in the do while loop
				System.out.println("Good-bye!");

			//otherwise we want to add it
			}else{
				//if user selects redo
				if(inp.equals("redo")){
					//check if there is something to actually redo
					if(redo.isEmpty()==true){
						//if nothing to redo, say there is nothing to redo and start again
						System.out.println("result > no more edits left in undo history");
					}else{
						//remove the first redo
						String h = redo.pop();
						System.out.println("Redid "+h);
						//add it to the undo stack
						s.push(h);
						//s.push(redo.pop());
					}
				//otherwise they said something we want to add
				}else{
					//add whatever they inputted into the stack
					s.push(inp);
					//clear the redo stack as they can't redo anymore
					redo.clear();
				}
				//if the size of the stack gets to 10,
				if(s.getSize()==10){
					//then we want to remove the oldest undo value
					String d = s.dequeue();
					System.out.println("removed "+d+" command");
				}
			}
		//loop if the user doesn't select quit
		}while(!inp.equals("quit"));
	}
}