import java.util.Scanner;
import java.util.Arrays;
public class Q6{
    public static void main(String[] args){

        Scanner scanGrade = new Scanner(System.in);
        double grade[] = new double[10];

        for(int i=0; i<10; i++)
        {
            System.out.println("Please enter grade");
            grade[i] = scanGrade.nextDouble();

        }

        System.out.println("Average is: "+calculateAverage(grade));
        System.out.println("Median is: "+calculateMedian(grade));
        System.out.println("Number Failed is: "+calculateNumberFailed(grade));
        System.out.println("Number Passed is: "+calculateNumberPassed(grade));


    }

    public static double calculateAverage(double[] notes){
        double average=0;
        for(int i=0; i<notes.length; i++)
        {
            average+=notes[i];
        }
        average/=notes.length;
        return average;
    }

    public static double calculateMedian(double[] notes){
        Arrays.sort(notes);
        int l = notes.length;

        if(l%2==0)
        {
            return notes[l/2];
        }
        else
        {
            return (notes[(l-1)/2]+notes[(l/2)])/2;
        }

    }

    public static int calculateNumberFailed(double[] notes){
        int counter = 0;
        for(int i=0; i<notes.length; i++){
            if(notes[i]<50.0){
                counter++;
            }
        }
        return counter;
    }

    public static int calculateNumberPassed(double[] notes){
        int counter = 0;
        for(int i=0; i<notes.length; i++){
            if(notes[i]>=50.0){
                counter++;
            }
        }
        return counter;
    }

}