/*
 * Class: Q2.java
 *
 * Version Info: Program outputs as instructed by Exercise 2 on Lab01 (URL: http://www.site.uottawa.ca/~gvj/Courses/ITI1121/lectures/labs/lab1.html#)
 *
 * Date: January 15, 2019
 *
 * @author Kish Dubey
 */

public class Q2
{
	public static void main(String[]args)
	{
		for(int i=1; i<=30; i++)
		{
			if (i%15==0)
			{
				System.out.println(i+" FizzBuzz");
			}
			else if (i%5==0)
			{
				System.out.println(i+" Buzz");
			}
			else if (i%3==0)
			{
				System.out.println(i+" Fizz");
			}
		}
	}
}


      