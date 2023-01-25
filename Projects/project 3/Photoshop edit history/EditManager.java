/**
class that manages the edit manager UI
*/
import java.util.Scanner;

public class EditManager{
	public static void main(String[] args) {
		Stack s = new Stack();
		Scanner scan = new Scanner(System.in);
		String inp;
		do{

			System.out.println("");
			System.out.print("Type edit command> ");
			inp = scan.next();
			if(inp.equals("undo")){
				if(s.isEmpty()==true){
					System.out.println("result > no more edits left in undo history");
				}else{
					String undo = s.pop();
					System.out.println("result > undone "+undo+" command");
				}
				
			}else if(inp.equals("quit")){
				System.out.println("Good-bye!");
			}else{
				s.push(inp);
				if(s.getSize()==10){
					String d = s.dequeue();
					System.out.println("removed "+d+" command");
				}
			}

		}while(!inp.equals("quit"));
	}
}