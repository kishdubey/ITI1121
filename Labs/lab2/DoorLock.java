/*
 *
 * Version Info: Program outputs as instructed on Lab02 (URL:http://www.site.uottawa.ca/~gvj/Courses/ITI1121/lectures/labs/lab2.html)
 *
 * Date: January 30, 2019
 *
 * @author Kish Dubey
 */

public class DoorLock {

    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination = combination;
        open=false;
        activated=true;
        numberOfAttempts=0;
    }

    // Access methods.

    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) 
    {

        if(!activated)
        {
            if(combination.equals(this.combination))
            {
            numberOfAttempts=0;
            open=true;
            }
        }
        else
        {
            numberOfAttempts++;
        }

        if(numberOfAttempts==MAX_NUMBER_OF_ATTEMPTS){
            activated=false;
        }
        return open;
    }

    public void activate( Combination c ) {
        if(combination.equals(c)){
            activated=true;
        }
    }

}