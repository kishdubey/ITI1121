public class GameModel {

 // Your code here
 private static boolean[][] board;

 /**
  *  width of the game
  */
 private int width;

 /**
  * height of the game
  */
 private int height;

 private int currentIndex;

public GameModel(int width, int height) {
  this.width = width;
  this.height = height;

  currentIndex = 0;

  board = new boolean[height][width];

  for(int i=0; i<height; i++){
    for(int j=0; j<width; j++){
      this.board[i][j] = false;
    }
  }
}

public int getHeight(){
  return height;
}

public int getWidth(){
  return width;
}

private int getCurrentIndex(){
  return currentIndex;
}
//
// public boolean [][] getBoard(){
//   return board;
// }

public boolean isON(int i, int j){
  return this.board[i][j];
}

public void reset(){
  for(int i=0; i<height; i++){
    for(int j=0; j<width; j++){
      board[i][j] = false;
    }
  }
}

  public void set(int i, int j, boolean value){
    this.board[j][i] = value;
  }

  public String toString(){
    StringBuffer out = new StringBuffer();
    out.append("[");
    for(int i = 0; i < height; i++){
        out.append("[");
        for(int j = 0; j < width ; j++) {
            if (j>0) {
                out.append(",");
            }
            out.append(board[i][j]);
        }
        out.append("]"+(i < height -1 ? ",\n" :""));
    }
    out.append("]");
    return out.toString();
  }

}
