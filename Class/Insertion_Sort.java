import java.util.Arrays;

public class Insertion_Sort{
	public static int[] sort(int[] nums){
		int n = nums.length;
		for(int x = 0; x<n; x++){
			int curval = nums[x];
			int curpos = x;
			while(curpos>0 && curval<nums[curpos]){
				nums[curpos] = nums[curpos-1];
				curpos--;
			}
			nums[curpos] = curval;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = {30, 500, 60, 110, 5, 1, 2, 0, 79, 500, 600, 3, 100000};
		int[] ggs = sort(nums);
		System.out.println(Arrays.toString(ggs));
	}
}