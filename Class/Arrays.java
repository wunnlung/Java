import java.util.ArrayList;
import java.util.List;

public class Arrays{
	
	//returns copy, but doesn't work. got the code from class and idk how to fix
	public static int[] arrayCopy(int[] nums){
		int[] copy = new int[nums.length];
		for (int i = 0; i<nums.length; i++){
			copy[i]=nums[i];
		}
		return copy;
	}

	//this is average
	public static double average(int[] nums){
		double sum = 0;
		//int[] copy = new int[nums.length]; I really don't know what this line does
		//it works when i use nums instead of copy but ok
		int count = nums.length;
		
		for(int i = 0; i<count; i++){
			sum = sum + nums[i];
		}
		return (double)sum / count;

	}

	//this is the max function
	public static int findMax(int[] nums){
		//this still does nothing
		int[] copy = new int[nums.length];
		//creates max value; sets it as the first number in list
		int max = nums[0];
		//loops through the list of nums
		for(int i: nums){
			//checks if the current max number is bigger than the next in the list
			if(i>max){
				//if current max is smaller, replace the max
				max = i;
			}
		}
		//then return the max
		return max;

	}

	//this is R 1.5
	public static int sumThing(int n){
		int sum = 0;
		for(int i=0; i<n+1; i++){
			sum += i;
		}
		return sum;
	}

	//this is R 1.6 (extra credit)
	public static int sumOfOdds(int n){
		int sum = 0;
		//we can change it to step by 2 instead of 1
		for(int i=1; i<n+1; i=i+2){
			sum += i;
		}
		return sum;
	}

	//this is R 1.7 (extra credit)
	public static int sumOfSquares(int n){
		int sum = 0;
		for(int i=0; i<n+1; i++){
			int temp = i*i;
			sum += temp;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] n = {1,3,2,5,4,7,6,9,8,8,8};
		int num = 5;

		//print copy
		int[] copy = arrayCopy(n);
		for (int i: copy){
			System.out.println(i);
		}
		System.out.println(copy);
		System.out.println("");

		//average
		double avg = average(n);
		System.out.println("Average: "+avg);

		//sum
		int number = sumThing(num);
		System.out.println("Sum: "+number);

		//max
		int maximum = findMax(n);
		System.out.println("Maximum: "+maximum);

		//odd sum
		int odd = sumOfOdds(num);
		System.out.println("Sum of odds: "+odd);

		//sum of squares
		int square = sumOfSquares(num);
		System.out.println("Sum of squares: "+square);
	}

}
