//It counts the positive number in the array
public class A1Q1 {

    public static int countPositive(double[] array) {

        int positive = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] > 0){
                positive = positive + 1;
            }
        }return positive;

    }

}
