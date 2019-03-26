/*
 *
 * Version Info: Program outputs as instructed on Lab02 (URL:http://www.site.uottawa.ca/~gvj/Courses/ITI1121/lectures/labs/lab2.html)
 *
 * Date: January 30, 2019
 *
 * @author Kish Dubey
 */
public class Combination 
{
    private int a;
    private int b;
    private int c;

    public Combination( int first, int second, int third ) 
    {
        a = first;
        b = second;
        c = third;
    }

    public boolean equals( Combination other ) 
    {
        return ((other!=null)&&(a==other.a)&&(b==other.b)&&(c==other.c));
    }

    public String toString() 
    {
        return(a+":"+b+":"+c);
    }

}