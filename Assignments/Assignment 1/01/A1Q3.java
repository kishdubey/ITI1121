
//It checks the longest run of a number in an array.

public class A1Q3{
  public static int getLongestRun(double[] array){
    int longest=1;
    int current=1;
    int i=1;
    while(i<array.length){
      if (array[i]==array[i-1]){
        current+=1;
        if (current>longest){
          longest=current;

        }

      }
      else
      {
        current=1;
      }
      i++;


    }
    if(array.length==0)
    {return 0;}
    else
    {return longest;}
  }



  public static int getLongestRun(String[] array){
    int longest=1;
    int current=1;
    int i=1;
    while(i<array.length){
      if (array[i].equals(array[i-1])){
        current+=1;
        if (current>longest){
          longest=current;

        }

      }
      else
      {
        current=1;
      }
      i++;


    }
    if(array.length==0)
    {return 0;}
    else
    {return longest;}
    }


  }
