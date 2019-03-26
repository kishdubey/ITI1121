
//QUESTION:2.1
import java.util.Random;
//The object of die stores an integer value in the range 1 to 6, inclusively.
public class Die{
  public static final int MAXVALUE = 6;
  private int a;
  Random number = new Random();
  public Die(){
    a = number.nextInt(6) + 1;
  }
  public int getValue(){
    return a;   //It returns the current value of die object.

  }
  public void roll(){
    this.a = number.nextInt(6) + 1; //It changes the value of die to some random number.

  }

  public String toString(){
    return "Die {value:"+this.a+"}"; // It represents the string representation of die object.
  }

}
