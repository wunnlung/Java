public class Distinct_Arrays{
	public static boolean distinct(int[] nums){
		boolean dist = true;
		for (int i = 0; i<nums.length; i++){
			for (int j = 0; j<nums.length; j++){
				if(nums[j]==nums[i]){
					if (j==i){
						continue;
					}else{
						dist = false;
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		int[] numbers = {1,3,2,5,4,7,6,9,8};
		boolean d = distinct(numbers);
		System.out.println(d);
	}
}