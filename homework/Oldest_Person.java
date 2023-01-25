public class Oldest_Person{
	//Big O notation is just O(n)
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
		return names[index];
	}

	public static void main(String[] args) {
		String[] name = {"a", "b", "c", "d"};
		int[] age = {1,3,4,2};
		String oldie = age_thing(age, name);
		System.out.println(oldie);
	}
}