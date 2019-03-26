

/**
 * The class <b>Solution</b> is used
 * to store a (partial) solution to the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class Solution {


    // Your variables here
    private boolean [][] board;
    private int set;
    private int row;
    private int col;


    /**
     * Constructor. Creates an instance of Solution
     * for a board of size <b>widthxheight</b>. That
     * solution does not have any board position
     * value explicitly specified yet.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     */
    public Solution(int width, int height) {

        //Your code here
        board = new boolean[height][width];
        set = width*height;
        row = 0;
        col = 0;
    }

    /**
     * Constructor. Creates an instance of Solution
     * wich is a deep copy of the instance received
     * as parameter.
     *
     * @param other
     *  Instance of solution to deep-copy
     */
    public Solution(Solution other) {

        //Your code here
        board = new boolean[other.getBoard().length][other.getBoard()[0].length];
        set = other.getSet();
        row = other.getRow();
        col = other.getCol();
        for(int i = 0; i<board.length;i++)
            for(int j =0; j<board[i].length;j++)
                board[i][j] = other.getBoard()[i][j];

    }

    public boolean[][] getBoard() {
        return board;
    }

    public int getSet() {
        return set;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /**
     * returns <b>true</b> if and only the parameter
     * <b>other</b> is referencing an instance of a
     * Solution which is the ``same'' as  this
     * instance of Solution (its board as the same
     * values and it is completed to the same degree)
     *
     * @param other
     *  referenced object to compare
     */

    public boolean equals(Object other){

        //Your code here
        if(!(other instanceof Solution))
            return false;
        Solution o = (Solution) other;
        if (board.length != o.getBoard().length && board[0].length != o.getBoard()[0].length)
            return false;

        for(int r = 0; r < board.length;r++)
            for(int c = 0; c<board[r].length;c++)
                if(board[r][c]!= o.getBoard()[r][c])
                    return false;

        return set == o.getSet() && row == o.getRow() && col == o.getCol();

    }


    /**
     * returns <b>true</b> if the solution
     * has been entirely specified
     *
     * @return
     * true if the solution is fully specified
     */
    public boolean isReady(){

        //Your code here
        return set == 0;
    }

    /**
     * specifies the ``next'' value of the
     * solution.
     * The first call to setNext specifies
     * the value of the board location (1,1),
     * the second call specifies the value
     *  of the board location (1,2) etc.
     *
     * If <b>setNext</b> is called more times
     * than there are positions on the board,
     * an error message is printed out and the
     * call is ignored.
     *
     * @param nextValue
     *  the boolean value of the next position
     *  of the solution
     */
    public void setNext(boolean nextValue) {

        //Your code here
        if(set == 0)
            return;
        if(!(col < board[row].length)){
            col = 0;
            row++;
        }
        board[row][col] = nextValue;
        col++;
        set--;
    }

    /**
     * returns <b>true</b> if the solution is completely
     * specified and is indeed working, that is, if it
     * will bring a board of the specified dimensions
     * from being  entirely ``off'' to being  entirely
     * ``on''.
     *
     * @return
     *  true if the solution is completely specified
     * and works
     */
    public boolean isSuccessful(){

        //Your code here
        int t;
        for(int i=0, row = board.length;i<row;i++)
            for(int j=0, col = board[i].length;j<col;j++){
                t = 0;
                try{
                    if(board[i][j])
                        t++;
                }
                catch(Exception e){

                }
                try{
                    if(board[i-1][j])
                        t++;
                }
                catch(Exception e){

                }
                try{
                    if(board[i+1][j])
                        t++;
                }
                catch(Exception e){

                }
                try{
                    if(board[i][j-1])
                        t++;
                }
                catch(Exception e){

                }
                try{
                    if(board[i][j+1])
                        t++;
                }
                catch(Exception e){

                }
                if(t%2 == 0)
                    return false;
            }


        return true;

    }
    /**
     * this method ensure that add <b>nextValue</b> at the
     * currentIndex does not make the current solution
     * impossible. It assumes that the Solution was
     * built with a series of setNext on which
     * stillPossible was always true.
     * @param nextValue
     *         The boolean value to add at currentIndex
     * @return true if the board is not known to be
     * impossible (which does not mean that the board
     * is possible!)
     */
    public boolean stillPossible(boolean nextValue) {

        //Your code here
        int a = nextValue?1:0;
        int r = row;
        int c = col;
        if(col>board[0].length-1){
            c=0;
            r++;
        }


        if(r==0)
            return true;
        int u = totalU(r,c);
        if((u+a)%2==0)
            return false;

        if(r == board.length-1) {
            int l = totalL(r,c);
            if (c > 0 && (l + a) % 2 == 0)
                return false;
        }


        return true;
    }
    private int totalU(int r, int c){
        int t = 0;
        try{
            if(board[r-1][c])
                t++;
        }
        catch(Exception e){

        }
        try{
            if(board[r-1][c-1])
                t++;
        }
        catch(Exception e){

        }
        try{
            if(board[r-1][c+1])
                t++;
        }
        catch(Exception e){

        }
        try{
            if(board[r-2][c])
                t++;
        }
        catch(Exception e){

        }
        return t;
    }
    private int totalL(int r, int c){
        int t = 0;
        try{
            if(board[r][c-1])
                t++;
        }
        catch(Exception e){

        }
        try{
            if(board[r-1][c-1])
                t++;
        }
        catch(Exception e){

        }
        try{
            if(board[r][c-2])
                t++;
        }
        catch(Exception e){

        }

        return t;
    }

    private int[][] reached(){
        int [][] nReached = new int [board.length][board[0].length];
        for(int r = 0; r<board.length; r++)
            for(int c = 0; c<board[r].length;c++){
                if(board[r][c]) {
                    nReached[r][c]++;
                    try {
                        nReached[r - 1][c]++;
                    } catch (Exception e) {

                    }
                    try {
                        nReached[r][c - 1]++;
                    } catch (Exception e) {

                    }
                    try {
                        nReached[r + 1][c]++;
                    } catch (Exception e) {

                    }
                    try {
                        nReached[r][c + 1]++;
                    } catch (Exception e) {

                    }
                }
            }
            return nReached;
    }
    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {

        //Your code here
        String str="[";
        for (int r = 0; r<board.length;r++){
            str+="[";
            for (int c = 0; c<board[r].length; c++) {
                str += board[r][c];
                if(c+1 != board[r].length)
                    str+= ",";
            }
            str+= "]";
            if(r+1 != board.length)
                str+=",\n";

        }
        str+="]";
        return str;
    }

}
