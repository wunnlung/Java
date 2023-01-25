//java basics
//int hehe = 0;
//double average = 93.6;
// boolean playthingidk = False;
// char grade = 'A';

// int prime = 2;
// int num;
// num = prime;
// num = 99;
// System.out.println(prime);
// System.out.println(num);

// int num;
// for (num=0; num<10; num++){
// 	System.out.println(num+"hello");
// }

//int[] numArray; //declaration
//numArray = {40, 33, 19, 23, 100, 90, 12}; //initialization
//numArray = new int[7]

//for (int num=0; num<7; num++){
//	System.out.println(numArray[num])
//}


public class javaBasics{
	public static void main (String[] args) {
		//dont have int num so we can save memory

		int sum = 0;
		for (int num=1; num<11; num++){
			//now num will only appear in the for loop
			sum = sum+num;
		}
		System.out.println(sum);
	}
}