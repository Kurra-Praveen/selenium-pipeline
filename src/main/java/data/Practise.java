package data;

import org.apache.commons.compress.archivers.ar.ArArchiveEntry;

import java.awt.font.NumericShaper;
import java.util.*;

public class Practise {
	public static void main(String[] args) {

		String name="Praveen";

		System.out.println(name.compareTo("praveen"));

//		Set<Character>characters=new HashSet<>();
//
//		StringBuilder uniqueString=new StringBuilder();
//
//		for(char c: name.toCharArray()){
//			if(!characters.contains(c) || Character.isWhitespace(c)){
//				characters.add(c);
//				uniqueString.append(c);
//			}else{
//				System.out.println("Already exist char "+c);
//			}
//		}
//		System.out.println(uniqueString.toString());

		System.out.println(reverseAString(name));

		System.out.println(calculateNonSpaceChars(name));

		System.out.println(factorialOfANumberR(5));

		System.out.println(factorialRecursionUsingI(5));

		System.out.println(findLargestNumber(new int []{2,4,1,5,22,63,2,466,3}));

		System.out.println(Arrays.toString(sortArray(new int[]{2, 4, 1, 5, 22, 63, 2, 466, 3})));
	}

	public static String reverseAString(String name){

		StringBuilder reversedString=new StringBuilder();

		for (int i= name.length()-1;i>=0;i--){

			reversedString.append(name.charAt(i));
		}

		return reversedString.toString();
	}

	public static int calculateNonSpaceChars(String input){
		int count=0;
		for(char c:input.toCharArray()){

			if(Character.isWhitespace(c)){

				count++;
			}
		}
		return count;
	}

	public static int factorialOfANumberR(int number){

		if(number==1)return 1;

		return number*factorialOfANumberR(number-1);
	}

	public static int factorialRecursionUsingI(int number) {
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public boolean isAnagrams(String input1, String input2){

		input1=input1.replaceAll("\\s","");

		input2=input2.replaceAll("\\s","");

		if(input1.length()!=input2.length())return false;

		char[] charArray = input1.toCharArray();

		char[] charArray1 = input2.toCharArray();

		Arrays.sort(charArray);

		Arrays.sort(charArray1);

		return Arrays.equals(charArray,charArray1);

	}
	public void swapTwoNumber(int a, int b){
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);
		System.out.println(b);
	}

	public static int findLargestNumber(int [] numbers){

		int largerst=Integer.MIN_VALUE;

		for(int number : numbers){

			if (number>largerst){

				largerst=number;
			}
		}
		return largerst;
	}

	public static int [] sortArray(int [] number){

		int temp;

		for(int i=0;i<number.length;i++){

			for(int j=i+1;j<number.length;j++){

				if(number[i]<number[j]){

					temp=number[i];

					number[i]=number[j];

					number[j]=temp;
				}
			}
		}

		return number;
	}

	public static int countNoOfVoles(String input){

		String vowels="aeiou";

		int count=0;

		for(char c : input.toCharArray()){

			if(vowels.indexOf(c)!=-1){
				count++;
			}
		}

		return count;
	}
}
