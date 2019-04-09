/**
* A Binary Search Tree implementation of the interface WordMap.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/

public class TreeWordMap implements WordMap {

  private static class Elem {

    private String key;
    private int count;
    private Elem left, right;

    private Elem(String key) {
      this.key = key;
      count = 1;
    }

  }

  private Elem root;
  private int size;

  /**
  * Returns true if and only if this WordMap contains the specified
  * word.
  *
  * @param word the specified word
  * @return true if and only if this WordMap contains the specified word
  * @throws NullPointerException if the value of the parameter is null
  */

  public boolean contains(String key) {
    boolean found = false;
    Elem current = root;
    while (! found && current != null) {
      int test = key.compareTo(current.key);
      if (test == 0) {
        found = true;
      } else if (test < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return found;
  }

  /**
  * Increments by 1 the counter associated with the specified
  * word. If the specified word is absent from the data structure,
  * a new association is created.
  *
  * @param word the specified word
  * @throws NullPointerException if the value of the parameter is null
  */

  public void update(String key) {
    if (key == null) {
      throw new NullPointerException();
    }
    if(root == null){
      root = new Elem(key);
      size++;
    }
    else{
      Elem current = root;
      boolean done = false;
      while (! done && current != null) {
        int test = key.compareTo(current.key);
        if (test == 0) {
          done = true;
          current.count++;
        } else if (test < 0) {
          if(current.left == null) {
            current.left = new Elem(key);
            done = true;
            size++;
          }
          else
          current = current.left;
        } else {
          if(current.right == null) {
            current.right = new Elem(key);
            done = true;
            size++;
          }
          else
          current = current.right;
        }
      }

    }

  }

  /**
  * Returns the count associated with the specified word or 0 if
  * the word is absent.
  *
  * @param word the specified word
  * @return the count associated with the specified word or 0 if absent
  * @throws NullPointerException if the value of the parameter is null
  */

  public int get(String key) {
    boolean found = false;
    Elem current = root;
    while (current != null) {
      int test = key.compareTo(current.key);
      if (test == 0) {
        return current.count;
      } else if (test < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    return 0;
  }

  /**
  * Returns the logical size of this WordMap. That is the number of
  * associations currently stored in it.
  *
  * @return the logical size of this WordMap
  */

  public int size() {
    return size;
  }

  /**
  * Returns all the keys (words) of this WordMap using their
  * natural order.
  *
  * @return all the keys (words)
  */

  private int index;
  public String[] keys() {
    String[] keys = new String[size];
    index = 0;
    recKeys(root, keys);
    return keys;
  }

  private void recKeys(Elem path, String[] keys){
    if(path.right == null && path.left == null)
    keys[index++]= path.key;
    else{
      if(path.left != null)
      recKeys(path.left, keys);
      keys[index++] = path.key;
      if(path.right != null)
      recKeys(path.right, keys);
    }


  }
  /**
  * Returns all the counts associated with keys in this
  * a4.WordMap. The counts are in the same order as that of the keys
  * returned by the method keys().
  *
  * @return all the counts
  */

  public Integer[] counts() {
    Integer[] counts = new Integer[size];
    index = 0;
    recCounts(root, counts);
    return counts;

  }
  private void recCounts(Elem path, Integer[] counts){
    if(path.right == null && path.left == null) {
      counts[index++] = path.count;
    }
    else{
      if(path.left != null)
      recCounts(path.left,  counts);
      counts[index++] = path.count;
      if(path.right != null)
      recCounts(path.right, counts);
    }



  }

}
