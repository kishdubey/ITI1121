public class Cashier {

  // Constant

  private static final String nl = System.getProperty( "line.separator" );

  // Instance variables

  private Queue<Customer> queue;
  private Customer currentCustomer;

  private int totalCustomerWaitTime;
  private int customersServed;
  private int totalItemsServed;

  // constructor

  public Cashier(){
    // Your code here.
    queue=new ArrayQueue<Customer>();
    totalCustomerWaitTime=0;
    customersServed=0;
    totalItemsServed=0;
    currentCustomer = null;
  }

  public void addCustomer( Customer c ) {
    // Your code here.
    queue.enqueue(c);


  }

  public int getQueueSize() {
    // Your code here.
    return queue.size();
  }

  public void serveCustomers( int currentTime ){
    // Your code here.
    if (currentCustomer == null && queue.isEmpty()){
      return;
    }
    else if (currentCustomer != null){
      if (currentCustomer.getNumberOfItems() == 0) {
        if (! queue.isEmpty()){
          currentCustomer = queue.dequeue();
          totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
          currentCustomer.serve();
          customersServed += 1;
          totalItemsServed += 1;
        }
      }

      else {
        currentCustomer.serve();
        totalItemsServed += 1;
      }
    }
    else {
      currentCustomer = queue.dequeue();
      totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();

      currentCustomer.serve();
      customersServed += 1;
      totalItemsServed += 1;
    }
  }
  public int getTotalCustomerWaitTime(){
    return totalCustomerWaitTime;
  }
  public  int getTotalItemsServed(){
    return totalItemsServed;
  }
  public int getTotalCustomersServed(){
    return customersServed;
  }

  public String toString() {

    StringBuffer results = new StringBuffer();

    results.append( "The total number of customers served is " );
    results.append( customersServed );
    results.append( nl );

    results.append( "The average number of items per customer was " );
    results.append( totalItemsServed / customersServed );
    results.append( nl );

    results.append( "The average waiting time (in seconds) was " );
    results.append( totalCustomerWaitTime / customersServed );
    results.append( nl );

    return results.toString();
  }
}
