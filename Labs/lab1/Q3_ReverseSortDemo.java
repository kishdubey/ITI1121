/*
 * Version Info: Program outputs as instructed by Exercise 3 on Lab01 (URL: http://www.site.uottawa.ca/~gvj/Courses/ITI1121/lectures/labs/lab1.html#)
 *
 * Date: January 17, 2019
 *
 * @author Kish Dubey
 */
import java.util.Arrays;

public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values)
	{
		Arrays.sort(values);
		char a[] = new char [values.length];
		int b = 0;
		for (int i=values.length-1; i>=0; i--, b++)
		{
			a[b] = values[i];
		}
		
		for (int c=0; c<values.length; c++)
		{
			values[c] = a[c];
		}
		
		

	}

		
	

}