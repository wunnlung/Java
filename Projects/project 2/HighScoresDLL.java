import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class HighScoresDLL{
	//all of the items
	public DNode head;
	public DNode tail;
	public int nElems;

	//cunstructor
	public HighScoresDLL(){
		head = null;
		tail = null;
		nElems = 0;
	}

	//add game entry
	public void add(GameEntry e){
		//create the actual Dnode
		DNode input = new DNode(null, e, null);
		//if the list is empty...
		if(nElems==0){
			//just add the Dnode
			head = input;
			tail = input;
			nElems++;
			//end function
			return;
		}
		//head temp and tail temp
		DNode htemp = head;
		DNode ttemp = tail;
		//loop forever
		while(true){
			System.out.println(input.entry);
			System.out.println(htemp.entry);
			//if the input score is lower than the head score, input it there
			if(input.entry.getScore()<htemp.entry.getScore()){
				DNode prevtemp = htemp.prev;
				//if its the head
				if(prevtemp == null){
					//set input as the new head
					head = input;
					input.next = htemp;
					htemp.prev = input;
					nElems++;
					return;
				}
				//run this if it's not the head and we need to add it
				prevtemp.next = input;
				input.prev = prevtemp;
				input.next = htemp;
				htemp.prev = input;
				nElems++;
				return;
			}

			if(input.entry.getScore()>ttemp.entry.getScore()){
				DNode nexttemp = ttemp.next;
				//if its the tail
				if(nexttemp == null){
					//set it as the new tail
					tail = input;
					input.prev = ttemp;
					ttemp.next = input;
					nElems++;
					return;
				}
				//only go through here if it isn't the tail
				nexttemp.prev = input;
				input.next = nexttemp;
				input.prev = ttemp;
				ttemp.next = input;
				nElems++;
				return;
			}
			//if it doesn't fit rn, then we move onto the next
			htemp = htemp.next;
			ttemp = ttemp.prev;
		}
	}

	//remove i
	public GameEntry remove(int i){
		DNode temp = head;
		//loop through until we get temp
		for(int n=0; n<i-1; n++){
			temp = temp.next;
		}
		//remove temp+1
		DNode ret = temp.next;
		temp.next = temp.next.next;
		//set the tail
		tail = temp.next;
		return ret.entry;
	}

	//display
	public void display(){
		//always a true statement:
		//create a temp variable for printing
		DNode temp = head;
		int a = 6;
		int b = 6;
		while(a==b){
			//print out the game entry
			System.out.println(temp.entry);
			//if there are no more elements...
			if(temp.next==null){
				//end the function
				return;
			}
			//move up the Dnode!
			temp = temp.next;
		}
	}
}


class HighScoresDLLTest{

	public static void main(String[] args) throws IOException {
		HighScoresDLL hsList = new HighScoresDLL();
		
		/* basic tests that I used
		//a bunch of game entries
		GameEntry ge1 = new GameEntry("Grand Master",2);
		GameEntry ge2 = new GameEntry("hehe",4);
		GameEntry ge3 = new GameEntry("haha",1);
		GameEntry ge4 = new GameEntry("Funny Number",5);
		GameEntry inp = new GameEntry("GE input",3);

		hsList.add(ge1);
		hsList.add(ge2);
		hsList.add(ge3);
		hsList.add(ge4);
		hsList.display();
		*/

		//creating Scanner for inputs
		Scanner inp = new Scanner(System.in);
		//creating random for random numbers
		Random rand = new Random();

		//welcome message
		System.out.println("welcome to rock paper scisors!");	
		try {
  			TimeUnit.SECONDS.sleep(2); 
		} catch (InterruptedException e) {
  			Thread.currentThread().interrupt();
		}

		//create variable for continuing
		Boolean cont = true;
		//will loop through until we don't want to continue
		while(cont==true){
			System.out.println("Enter your name:");
			//get the name for the current player
			String name = inp.next();
			//set the var for the score of the user
			int score = 0;
			//will make sure it keeps going until the player loses
			Boolean win = true;

			//actual game
			while(win==true){
				//very basic test
				//hit 1 to add score,
				//anything else loses
				/*int g = inp.nextInt();
				if(g==1){
					score++;
				} else{
					win=false;
				}*/

				System.out.println("");
				//print current score
				System.out.println("Current score = "+ score);
				//rock paper scisors
				System.out.println("Select: r for rock, p for paper, or s for scisors:");
				//user selects
				String u = inp.next();
				//bot selects random number from 1-3
				int bot = rand.nextInt(3);
				//this is all for turning it into a string
				String b;
				if(bot==0){
					//0 is rock
					b="r";
					System.out.println("bot chose Rock!");
				}else if(bot==1){
					//1 is paper
					b="p";
					System.out.println("bot chose Paper!");
				}else{
					//2 is scisors 
					b="s";
					System.out.println("bot chose Scisors!");
				}

				//checking who won
				if(u.equals(b)){
					//tie
					System.out.println("Draw!");
				}else if(u.equals("r") && b.equals("s")){
					score++;
					//rock beats scisors
					System.out.println("You win!");
				}else if(u.equals("p") && b.equals("r")){
					score++;
					//paper beats rock
					System.out.println("You win!");
				}else if(u.equals("s") && b.equals("p")){
					score++;
					//scisors beat paper
					System.out.println("You win!");
				}else{
					System.out.println("You lost!");
					//will exit the loop
					win=false;
				}
				//sleep
				try {
  					TimeUnit.SECONDS.sleep(2); 
				} catch (InterruptedException e) {
  					Thread.currentThread().interrupt();
				}

			}

			//game over when the player loses
			System.out.println("Game over!");
			//System.out.println(name);
			//System.out.println(score);
			//create game entry
			GameEntry ge = new GameEntry(name, score);
			//add it to the list
			hsList.add(ge);

			//sleep
			try {
  				TimeUnit.SECONDS.sleep(2); 
			} catch (InterruptedException e) {
  				Thread.currentThread().interrupt();
			}

			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("Select 1 to continue, 2 to show scores, and 3 to end the game");
			//gives player a choice
			int choice = inp.nextInt();
			if(choice==2){
				//shows scores
				hsList.display();
				System.out.println("Select 1 to continue or 2 to end the game");
				//then have another choice to continue or end
				int choice2 = inp.nextInt();
				if(choice2==2){
					//end the game
					cont=false;
					System.out.println("");
					System.out.println("Thanks for playing!");
				}
			} else if(choice==3){
				//also end the game (from original choice)
				cont=false;
				System.out.println("");
				System.out.println("Thanks for playing!");
			}

		}
		//if continue was selected, then it will loop back to top
		//otherwise it will end program

		

		
	}
}














