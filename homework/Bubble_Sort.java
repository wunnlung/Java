import java.util.Arrays;

public class Bubble_Sort{
	//run time is O(n^2)
	public static int[] bubble(int[] nums){
		//creates n of length nums
		int n = nums.length;
		for(int i = 0; i<n; i++){ //for integers in the list
			for(int j = 0; j<n-i-1; j++){ //for the indexes in the list
				//if the current number is greater than the next number...
				if (nums[j] > nums[j + 1]) {
					//pretty much just swaps them
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
			}
		}
		return nums;
	}

	public static int binarySearch(int[] nums, int key, int low, int high){
		//pretty much just did your code and added the other stuff
		int index = 0;
		while (low<=high){
			int middle = low + (high-low)/2;
			if(nums[middle]<key){
				low=middle+1;
			} else if(nums[middle]>key){
				high = middle-1;
			} else if(nums[middle]==key){
				return middle;
			}
		}
		return -1;
	}

	public static String[] name_sort(int[] nums, String[] names){
		//run time is also O(n^2)
		//everything is identical to bubble sort above
		int n = nums.length;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n-i-1; j++){
				if (nums[j] > nums[j + 1]) {
					//except this
                    int temp = nums[j+1];
                    //added the exact same parameters to the string array too
                    String sTemp = names[j+1];
                    nums[j+1] = nums[j];
                    names[j+1] = names[j];
                    nums[j] = temp;
                    names[j] = sTemp;
                }
			}
		}
		return names;
	}

	public static void main(String[] args) {
		int[] nums = {30, 500, 60, 110, 5, 1, 2, 0, 79, 500, 600, 3, 100000};
		int[] end = bubble(nums);
		int[] ages = {1,3,2,4};
		String[] names = {"a", "b", "c", "d"};
		String[] s = name_sort(ages, names);
		//System.out.println(Arrays.toString(s));
		int fin = binarySearch(end, 6,0,10);
		System.out.println(Arrays.toString(end));
		//System.out.println(fin);
	}
}