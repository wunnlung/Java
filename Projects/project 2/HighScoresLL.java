public class HighScoresLL{

	//create class items n stuff
	private Node head;
	private Node tail;
	//I know its supposed to be size, but
	//I like nElems from the last project
	private int nElems;


	//constructor
	public HighScoresLL(){
		head = null;
		tail = null;
		nElems = 0;
	}

	//add first
	public void addFirst(Node v){
		//if it's the first input...
		if(nElems==0){
			//sets the head as the inputed node
			head = v;
			//there is only one node, so there is no next item
			head.next = null;
			//increase the total size 1
			nElems++;
			//sets the tail also
			tail = head;
			//end the function
			return;
		}
		//don't need an else, because the function would have
		//ended in the if statement
		//create a temp for the current head
		Node temp = head;
		//set the new head
		head = v;
		//set the next node as the previous head
		head.next = temp;
		//increase nElems by 1
		nElems++;
		//end the function
		//don't need to change tail as it stays the same
		return;
	}

	//remove first
	public Node removeFirst(){
		//if there is only one element...
		if(nElems==1){
			//create a temp for returning
			Node temp = head;
			//just set the head to null
			head = null;
			//also the tail
			tail = null;
			//and just set nElems to 0
			nElems = 0;
			//return because that's all we need to do
			return temp;
		}
		//no else, as if it goes through if statement it just ends
		//create a temp for returning
		Node temp = head;
		//set the new head
		head = head.next;
		//decrease total elements
		nElems--;
		//return the Node that was removed
		return temp;
		//tail stays the same
	}

	//add last
	public void addLast(Node v){
		//set the last node as v
		tail.next = v;
		//set it as the new tail
		tail=tail.next;

		//worse way of doing it. changed it to above
		/*
		//assuming that it isn't empty, as there is an addFirst
		//set the temp node that we move as the head
		Node temp = head;
		//will run until I don't want it to run
		int a = 4;
		int b = 2+2;
		while(a==b){		//6 will always equal 6 haha
			//if the next element is empty...
			if(temp.next==null){
				//we can add v as the next node
				temp.next = v;
				//and set v's next as null
				v.next = null;
				//and increase the nElems
				nElems++;
				//now we won't need to exit the while loop,
				//we just return
				return;
			}
			//if it doesn't go through the if statement,
			//that means there are more elements
			//move onto the next element
			temp = temp.next;
		}*/
	}

	//add game entry object
	public void add(GameEntry e){
		//creating a new node of the gameEntry
		Node input = new Node(e, null);
		//variable for the score of the input GE
		int score = e.getScore();
		//temp variable for the current node
		Node temp = head;
		//temp next variable for the next node from temp
		Node tnext = temp.next;
		//variable for the node score
		int nScore = tnext.entry.getScore();

		//use this only if there should be a set number of high scores
		//check if it's even a high score
		//welp doesn't matter because we still just want to add so nvm
		
		/*
		if(temp.entry.getScore()>score){
			//ends the function as it's not a high score
			return;
		}
		*/
		
		//will always loop because why not
		while(6==6){
			//if the score is a new highEST score...
			if(tnext.next == null){
				//add it to the front
				addLast(input);
				
				nElems++;

				//end the function
				return;
			}
			//if the score is higher
			if(score<nScore){
				//input it at the current spot
				//otherwise input it at the current spot
				temp.next = input;
				input.next = tnext;
				return;
			}
			//set the current node to the next node
			temp = temp.next;
			//set tnext
			tnext = tnext.next;
			//get the score to check
			nScore = tnext.entry.getScore();

			
		}
		/*//if the high score goes in place of the first node
		if(temp==head){
			addFirst(input);
		}*/
	}

	public GameEntry remove(int i){
		Node temp = head;
		//loop through until we get temp
		for(int n=0; n<i-1; n++){
			temp = temp.next;
		}
		//remove temp+1
		Node ret = temp.next;
		temp.next = temp.next.next;
		//set the tail
		tail = temp.next;
		return ret.entry;
	}

	//display
	public void display(){
		//always a true statement:
		//create a temp variable for printing
		Node temp = head;
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
			//move up the node!
			temp = temp.next;
		}
	}


}

//testing class
class HighScoresLLTest{

	public static void main(String[] args) {
		HighScoresLL hsList = new HighScoresLL();
		//a bunch of game entries
		GameEntry ge1 = new GameEntry("Grand Master",2);
		GameEntry ge2 = new GameEntry("hehe",4);
		GameEntry ge3 = new GameEntry("haha",1);
		GameEntry ge4 = new GameEntry("Funny Number",5);
		GameEntry inp = new GameEntry("GE input",3);

		//all the nodes
		Node v = new Node(ge1, null);
		Node w = new Node(ge2, null);
		Node x = new Node(ge3, null);
		Node y = new Node(ge4, null);

		hsList.addFirst(v);
		hsList.addLast(w);
		hsList.addFirst(x);
		hsList.addLast(y);
		System.out.println("all of the nodes:");
		hsList.display();
		//hsList.removeFirst();
		//System.out.println("removing first element:");
		//hsList.display();
		System.out.println("");
		hsList.add(inp);
		System.out.println("adding highScore...");
		hsList.display();
		System.out.println("removing index 2:");
		hsList.remove(4);
		hsList.display();
	}
}










