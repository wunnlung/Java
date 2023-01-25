/** 
 * A class that allows access and manipulation of an array of numbers, providing 
 * a high-level interface for common array operations.
 * Filename: highArray.java (adapted from Robert Lafore's Data Structures text)
 */
import java.util.Arrays;

public class HighArray {

	private long[] a;        // private instance variable for array a
	private int nElems;      // private instance variable for number of data items

	/**
	 * Construct a new array of longs along with 
	 * an integer variable to track the number of elements in use
	 * @param max
	 *		specifies the size of the array
	 */
	public HighArray(int max) {  // constructor
		a = new long[max];        	// create the array
		nElems = 0;               	// no items yet
	}

	/**
	 * Finds the given value in the array
	 * @param searchKey
	 * 		the value to be searched for
	 * @return
	 *		true if searchKey is found, false otherwise
	 */

///////////////PART A/////////////////////////////
	//get max function
	public long getMax(){
		//runtime is O(n)

		//if the array is empty
		if (nElems == 0){
			//return -1
			return -1;
		}

		//otherwise get the max
		long max = a[0];
		for(long i: a){
			if(i>max){
				max=i;
			}
		}
		return max;
	}
///////////////PART B/////////////////////////////
	public long removeMax(){
		//runtime is O(n)

		//if the array is empty
		if (nElems == 0){
			//return -1
			return -1;
		}
		//finds the max again, but also keeps the index
		long max = a[0];
		for(long i: a){
			if(i>max){
				max=i;
			}
		}
		//removes the max from the array
		//same code as below but took out a couple things
		for(int j=0; j<nElems; j++){
			if(max==a[j]){
				for(int k=j; k<nElems; k++){
					a[k] = a[k+1];
				}
				nElems--;
			}
		}
		return max;

	}

///////////////PART D/////////////////////////////
	public boolean allDistinct(){
		//runtime is O(n^2)

		//loops through the array twice
		for(int i=0; i<nElems; i++){
			for(int j=0; j<nElems; j++){
				//only checks if it's not the same instance
				if(i!=j){
					//if they are equal values
					if(a[i]==a[j]){
						//then it isn't distinct
						return false;
					}
				}
			}
		}
		return true;
	}
///////////////PART C/////////////////////////////
	public void reverse(){
		//runtine is O(n)

		//checks if the array is empty
		if(nElems==0){
			//just end the function
			return;
		}
		//lowest index
		int i1 = 0;
		//highest index
		int i2 = nElems-1;

		//for loop to loop through HALF the array
		for(int i=0; i<nElems/2; i++){
			//swaps
			long temp = a[i1];
			a[i1] = a[i2];
			a[i2] = temp;
			//increases lowest index
			i1++;
			//decreases highest index
			i2--;
		}
		return;
	}

	public boolean find(long searchKey) {
		//rintime is O(n)

		int j;
		for(j=0; j<nElems; j++) {           // for each element,
			if(a[j] == searchKey)           	// found item?
				return true;                       // exit loop before end
		}
		// gone to end of for loop
		return false;                   // yes, can't find it
	}  // end find()

	/**
	 * Inserts a new value into array a
	 * @param value
	 *		the value to be inserted
	 */
	public void insert(long value){   // put element into array
		a[nElems] = value;             // add element to the end of the array
		nElems++;                      // increment size
	}

	/**
	 * Deletes the specified value
	 * @param value 
	 * 		The value to be deleted
	 * @return 
	 * 		true if search and deletion was successful, false otherwise
	 */
	public boolean delete(long value) { 
		//runtme is O(n^2)
		int j;
		for(j=0; j<nElems; j++) {       // look for it
			if( value == a[j] ) {
				for(int k=j; k<nElems; k++) { // move higher ones down
					a[k] = a[k+1];
				}
				nElems--;                   // decrement size
				return true;				//exit entire function
			} //end if
		} //end for j
		return false; // can't find it if we made it this far
	} //end delete()

	/**
	 * Displays array contents
	 */
	public void display(){
		//runtime is O(n)
		
		for(int j=0; j<nElems; j++) {      // for each element,
			System.out.print(a[j] + " ");  // display it
		}
		System.out.println("");
	}
}  // end class HighArray

/**
 * This HighArrayTest class has only a main function.
 * It's purpose is only to test the HighArray class.
 */
class HighArrayTest
{
	public static void main(String[] args)
	{
		int maxSize = 100;            // array size
		HighArray arr;                // declare a variable of type HighArray
		arr = new HighArray(maxSize); // create the new HighArray object and assign it to arr

		arr.insert(77);               // insert 10 items
		arr.insert(35);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

//////////my tests/////////
		System.out.println(arr.getMax());
		arr.removeMax();
		System.out.println(arr.allDistinct());
		arr.display();          	// display items
		arr.reverse();
		arr.display();

///////////////////////////
		int searchKey = 35;         // value to search for
		if( arr.find(searchKey) )	//search for item
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.delete(00);               // delete 3 items
		arr.delete(55);
		arr.delete(99);

		arr.display();                // display items again
	}  // end main()
}  // end class HighArrayTest