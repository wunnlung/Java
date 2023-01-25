public class linkedListStuff{
	public void merge(Node L, Node M){
		//creating a bool for the while loop
		Boolean more = true;
		//sets the head to the first node of L
		head = L
		//while there is still more items in the node...
		while(more==true){
			//if the next element is null, set "more" to false
			if(L.next==null){
				more = false;
			}
			//move onto the next node
			L=L.next;
		}
		//set the next node to the first node of the next list
		L.next = M 
		//resetting the bool for the next while loop
		more = true;
		//doing the same thing as the first while loop
		while(more==true){
			if(M.next==null){
				//makes it exit the while loop
				more = false;
				//creates a variable of the current node,
				//as it's the last
				Node cur = M
				//sets the tail as the current node
				tail = cur;
			}
			//setting the next Node in L to current M node
			L.next = M;
			//moving up in the L node
			L=L.next;
			//setting the next M node
			M=M.next;
		}
	}
	/*I can loop through the node with .next and search for the x and y values.
	with them, I can create a temp and just normally swap them
	I believe it would be faster in general to have a doubly linked list for this,
	specifically because I can search from both the head and the tail.
	So if x is closer to the head and y is closer to the tail, then it would be faster
	to search from both the head and tail than to just start at the head and loop all the
	way through
	So overall I believe that singly linked lists would take more time
	*/	
}