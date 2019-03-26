/*
 * A class to be the blueprint of rational numbers
 * 
 * @author: Kish Dubey
 * 
 */
public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
         this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
         this.denominator = denominator;
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
         int newNumerator = (numerator * other.numerator) + (other.numerator * denominator);
         int newDenominator = denominator*other.denominator;

         return new Rational(newNumerator, newDenominator);

    }

    public static Rational plus(Rational a, Rational b) {
        return a.plus(b);
    	
    }
    // Euclid's algorithm for calculating the greatest common divisor
    
     private int gcd(int a, int b) {
        while (a != b)
            if (a > b)
                 a = a - b;
            else
                 b = b - a;
        return a;
    }
    // Transforms this number into its reduced form
    private void reduce() {
      int common = gcd(Math.abs(numerator),denominator);
      numerator = numerator/common;
      denominator = denominator/common;
    }

    public int compareTo(Rational other) {
        int thisNewNum = other.denominator * numerator;
        int otherNewNum= other.numerator * denominator;
    
        return thisNewNum - otherNewNum;
    }

    public boolean equals(Rational other) {
        if(numerator == other.numerator && denominator == other.denominator){
            return true;
        }
        return false;
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = Integer.toString(numerator);
    	} else {
    	    result = numerator+"/"+denominator;
    	}
    	return result;
    }

}