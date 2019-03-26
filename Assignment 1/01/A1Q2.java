//It checks for the duplicate value in the array

public class A1Q2{
  public static boolean hasLengthTwoRun(double[] array){
  for (int i=0;i<array.length-1;i++){
    if(array[i]==array[i+1])
    {return true;
    }
  }return false;


  }






}
