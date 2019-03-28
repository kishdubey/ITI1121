public class Customer {

    // Constant

    private static final int MAX_NUM_ITEMS = 25;

    // Instance variables

    private int arrivalTime;
    private int numberOfItems;
    private int initialNumberOfItems;

    // Constructor

    public Customer( int arrivalTime ) {
        // Your code here.
        this.arrivalTime=arrivalTime;
        initialNumberOfItems=numberOfItems =  (int) ( ( MAX_NUM_ITEMS - 1 ) * Math.random() ) + 1;
    }

    // Access methods

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        // Your code here.
      return initialNumberOfItems - numberOfItems;


    }

    public void serve() {
        // Your code here.
        numberOfItems--;
    }
}
