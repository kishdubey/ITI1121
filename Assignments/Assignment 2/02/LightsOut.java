

import java.util.ArrayList;


/**
 * The class <b>LightsOut</b> is the
 * class that implements the method to
 * computs solutions of the Lights Out game.
 * It contains the main of our application.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class LightsOut {

    // Your variables here
    private static ArrayListSolutionQueue queue;
    private static ArrayList<Solution> solutions;


    /**
     * The method <b>solve</b> finds all the
     * solutions to the <b>Lights Out</b> game
     * for an initially completely ``off'' board
     * of size <b>widthxheight</b>, using a
     * Breadth-First Search algorithm.
     *
     * It returns an <b>ArrayList&lt;Solution&gt;</b>
     * containing all the valid solutions to the
     * problem.
     *
     * During the computation of the solution, the
     * method prints out a message each time a new
     * solution  is found, along with the total time
     * it took (in milliseconds) to find that solution.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     * @return
     *  an instance of <b>ArrayList&lt;Solution&gt;</b>
     * containing all the solutions
     */
    public static ArrayList<Solution> solve(int width, int height){

        //Your code here
        queue = new ArrayListSolutionQueue();
        solutions = new ArrayList<Solution>();
        queue.enqueue(new Solution(width, height));
        Solution current;
        long timeStart = System.currentTimeMillis();
        long timeEnd;
        while(!queue.isEmpty()){
            current = queue.dequeue();
            if(current.isReady()) {
                if (current.isSuccessful()) {
                    timeEnd = System.currentTimeMillis();
                    solutions.add(current);
                    System.out.println("Solution found in: " + ((timeEnd - timeStart)) + " ms");
                }
            }
            else{
                Solution ext = new Solution(current);
                if(current.stillPossible(true)) {
                    ext.setNext(true);
                    queue.enqueue(ext);
                }


                if(current.stillPossible(false)) {
                    current.setNext(false);
                    queue.enqueue(current);
                }
            }

        }

        return solutions;
    }

    /**
     * <b>main</b> method  calls the method <b>solve</b>
     * and then prints out the number of solutions found,
     * as well as the details of each solution.
     *
     * The <b>width</b> and <b>height</b> used by the
     * main are passed as runtime parameters to
     * the program. If no runtime parameters are passed
     * to the program, or if the parameters are incorrect,
     * then the default values are used.
     *
     * @param args
     *  Strings array of runtime parameters
     */
    public static void main(String[] args) {

        StudentInfo.display();

        //Your code here
        int width;
        int height;
        if(args.length == 2){
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }
        else{
            width = 3;
            height = 3;
        }

        solve(width,height);
        for(int i = 0; i<solutions.size();i++){
            System.out.println("****");
            System.out.println(solutions.get(i));
        }
        System.out.println("there are "+solutions.size()+" Solutions");

    }
}
