//import java.util.ArrayList;
//import java.util.List;
import java.util.Arrays;

//


public class Reverse_Array{

	//big O notation is just O(n)
	public static String age_thing(int[] ages, String[] names){
		String oldest = "";
		int count = 0;
		int index = 0;
		int max = ages[0];
		for(int i: ages){
			if (i>max){
				max = i;
				index = count;
			}
			count += 1;
		}
		System.out.println(index);
		return names[index];
	}

	/*public static void output_ages(int[] ages, String[] names){
		for(int i = 0; i<names.length; i++){
			if (names[i].equals(target)){
				System.out.println(names[i]+"is"+ages[i]+years old)
			}
		}
	}*/

	//big O notation is also just O(n)
	public static int[] reverse(int[] nums){
		int[] fin = new int[nums.length];
		int count = nums.length;
		for (int i: nums){
			count -= 1;
			fin[count] = i;
		}
		return fin;
	}

	public static void main(String[] args) {
		int[] n = {1,3,2,5,4,7,6,9,8};
		int[] rev = reverse(n);
		String[] name = {"a","b","c","d"};
		int[] age = {1,3,4,3};
		String oldie = age_thing(age, name);
		System.out.println(oldie);


		for (int num: rev){
			System.out.println(num);
		}
	}
}