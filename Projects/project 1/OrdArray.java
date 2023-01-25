/** 
* A class that allows access and manipulation of an ordered array of numbers, 
* providing a high-level interface for common array operations.
* Filename: OrdArray.java (adapted from Robert Lafore's Data Structures text)
*/


/*
Part H:
	2: in order for binary search to work, the array needs to be sorted already.
	In high array, its functions for random arrays, but OrdArray is already sorted

	3. No, it is not always better to use OrdArray. Specifically if you don't want the
	array to be sorted. However if you do want a sorted array, then OrdArray will be
	better for bigger arrays, as linear search has a faster runtime for smaller arrays

	4. I don't believe they do improve to O(logn), specifically because there are still
	for loops inside the function. If it was only finding the numbers and not inserting
	/ deleting, then it would be more efficient, but it is doing additional work

*/

import java.util.Random;
import java.util.Arrays;

public class OrdArray {

	private long[] a;		// private instance variable for array a
	private int nElems;		// private instance variable for number of data items
	
	/**
	 * Construct a new array of longs along with 
	 * an integer variable to track the number of elements in use
	 * @param max
	 *		specifies the size of the array
	 */
	public OrdArray(int max){          // constructor
		a = new long[max];             // create array
		nElems = 0;
	}

	/**
	 * Accessor method for nElems
	 * @return 
	 *		returns the number of array elements in use
	 */ 
	public int size() {
		return nElems; 
	}

	/**
	 * Finds the given value in the array
	 * @param searchKey
	 * 		the value to be searched for
	 * @return
	 *		the index where the searchKey is found, 
	 *		or the value of nElems if not found
	 */

////////////////////////FIND////////////////////////////////////////
	public int find(long searchKey) {
		//runtime is O(log(n))

		//sets low as 0
		int low = 0;
		//sets the high as 1 less than amount of numbers
		int high = nElems-1;
		//index is 0
		int index = 0;
		while (low<=high){
			int middle = low + (high-low)/2;
			if(a[middle]<searchKey){
				low=middle+1;
			} else if(a[middle]>searchKey){
				high = middle-1;
			} else if(a[middle]==searchKey){
				return middle;
			}
		}
		return -1;
	} // end find()


////////////////////////MERGE////////////////////////////////////////
	public void merge(long[] b){
		//runtime is O(n)

		for(long l: b){
			//now it will just run through the insert function
			insert(l);
		}
	}


////////////////////////SHUFFLE////////////////////////////////////////
	public void hack(){
		//runtime is O(n)

		//creates a random object called r
        Random r = new Random();
         
        // Starting from the last element and swapping one by one.
        for (int i = nElems-1; i > 0; i--) {
            //picks a random index from 0 to i
            int j = r.nextInt(i+1);
            //swaps array[i] with the element at random index
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
	}

////////////////////////SORT////////////////////////////////////////
	public void sort(){
		//runtime is O(n)

        for (int x=1; x<nElems; x++) {
           	long curval = a[x];
            int curpos = x-1;
            while (curpos>=0 && a[curpos]>curval) {
                a[curpos + 1] = a[curpos];
                curpos--;
            }
            a[curpos + 1] = curval;
        }
	}

	/**
	 * Inserts a new value into array a[]
	 * (Assumes the array is long enough to handle all items that will be inserted.)
	 * @param value
	 *		the value to be inserted
	 */

////////////////////////INSERT////////////////////////////////////////
	public void insert(long value) { // put element into array
		//runtime is O(n)

		//if the array is empty,
		//and its the first element we are inserting,
		//just insert it
		if(nElems==0){
			a[0] = value;
			nElems++;
			//System.out.println(nElems);
		}else{
			int lo = 0;
			int hi = nElems-1;
			int mid = 0;
			boolean foundIt = false;   //flag when we've found the position so the loop will stop
			while (!foundIt && lo <= hi){
				mid = lo + (hi-lo)/2;
				//System.out.println(mid);
				if(a[mid]<value){
					lo=mid+1;
				} else if(a[mid]>value){
					hi=mid-1;
				} else {
					//System.out.println("mid " + mid + " lo" + lo + " hi" + hi);
					foundIt = true;
				}
			}
			for(int k=nElems; k>mid; k--) {  // shift all bigger elements up
				//System.out.println(k+" k`");
				a[k] = a[k-1];
			}
			//if the value where we want to insert the number is smaller,
			if(a[mid]<value){
				//then we insert the number one up
				a[mid+1] = value;
			} else{
				//otherwise we put it in below
				a[mid] = value;
			}
		//increase by 1
		nElems++; 
		}


		/* j = 0;
		//find position where value should be inserted:
		//keep looking until we've gone too high or 
		//we've run out of values to look at
		while (a[j] <= value && j < nElems) { 	
			j++;  					// linear search
		}
		//j now holds the position where the value should be inserted
		for(int k=nElems; k>j; k--) {  // shift all bigger elements up
			a[k] = a[k-1];
		}
		a[j] = value;                  // insert the value
		nElems++;       */               // increment size
	}  // end insert()
	
	/**
	 * Deletes the specified value
	 * @param value 
	 * 		The value to be deleted
	 * @return 
	 * 		true if search and deletion was successful, false otherwise
	 */

////////////////////////DELETE////////////////////////////////////////
	public boolean delete(long value){
		//runtime is O(n)

		int index = find(value);
		if(index==-1){
			return false;
		}
		//doing the same thing as below, just with index
		for(int k = index; k<nElems; k++){
			a[k] = a[k+1];
		}
		//decreases size
		nElems--;
		//can only get to here if it actually deletes
		return true;
		
		/* previous code
		int j = 0;
		//find the value to be deleted:
		//keep looking until we've gone too high or 
		//we've run out of values to look at
		while (a[j] < value && j < nElems){  
			j++;  //linear search for value
		}
		if(a[j] == value) { // found it
			for(int k=j; k<nElems; k++) { // move bigger ones down
				a[k] = a[k+1];
			}                
			nElems--;                   // decrement size
			return true;	
		} //end if
		else { // value not found in the array
			return false;
		}  */
	}  // end delete()

	/**
	 * Displays array contents
	 */
	public void display(){            // displays array contents
		for(int j=0; j<nElems; j++)       // for each element,
		System.out.print(a[j] + " ");  // display it
		System.out.println("");
	}
	//-----------------------------------------------------------
}  // end class OrdArray

/**
 * This OrderedArrayTest class has only a main function.
 * It's purpose is only to test the OrderderedArray class.
 */
class OrderedArrayTest{

	public static void main(String[] args){
		int maxSize = 100;             // array size
		OrdArray arr;                  // reference to array
		arr = new OrdArray(maxSize);   // create the array

		arr.insert(77);                // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		arr.display();
		System.out.println("Adding another array...");
		long[] b = {10, 20, 30, 40, 50, 80, 60};
		arr.merge(b);
		arr.display();
		System.out.println("Oh no we've been hacked!");
		arr.hack();
		arr.display();
		System.out.println("repairing firewall...");
		arr.sort();
		arr.display();

		int searchKey = 55;            // search for item
		if( arr.find(searchKey) != -1 )
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.display();                 // display items

		arr.delete(00);                // delete 3 items
		arr.delete(55);
		arr.delete(99);

		arr.display();                 // display items again
	}  // end main()
}  // end class OrderedApp