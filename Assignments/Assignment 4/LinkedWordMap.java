import java.util.*;
/**
* An implementation of the interface WordMap using linked elements.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/

public class LinkedWordMap implements WordMap {
  private static class Node {

    private String value;
    private Node previous;
    private Node next;
    private int counter;

    private Node(){
      this.value = null;
      this.previous = null;
      this.next = null;
      this.counter = 1;
    }

    private Node (String value, Node next, Node previous, int counter) {
      this.value = value;
      this.previous = previous;
      this.next = next;
      this.counter = counter;
    }

    private void setCounter(int a){
      counter = a;
    }

    private int getCounter(){
      return counter;
    }

    private void setLinkNext(Node n){
      next = n;
    }

    private void setLinkPrev(Node n){
      previous = n;
    }

    private Node getLinkNext(){
      return next;
    }

    private Node getLinkPrev(){
      return previous;
    }

    private void setValue(String v){
      value = v;
    }

    private String getValue(){
      return value;
    }

  }

  private int size;
  private Node head, tail;
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
  * Returns true if and only if this WordMap contains the specified
  * word.
  *
  * @param key the specified word
  * @return true if and only if this WordMap contains the specified word
  * @throws NullPointerException if the value of the parameter is null
  */
  public boolean contains(String key) {
    Node tmp = head;
    int count=0;
    int flag = 0;

    if(size==0){
      return false;
    }

    if(key == null){
      throw new NullPointerException();
    }
    else {
      while(tmp.next != head){
        count++;

        if(tmp.getValue().equals(key)){
          flag = 1;
          count--;
          break;
        }
        tmp = tmp.next;
      }

      if(tmp.getValue().equals(key)){
        count++;
        flag = 1;
      }

    }
    if(flag==1){
      return true;
    }
    return false;
  }

  /**
  * Returns the count associated with the specified word or 0 if
  * the word is absent.
  *
  * @param key the specified word
  * @return the count associated with the specified word or 0 if absent
  * @throws NullPointerException if the value of the parameter is null
  */

  public int get(String key) {
    if(key == null){
      throw new NullPointerException();
    }

    Node tmp = head;

    if(!contains(key)){
      return 0;
    }
    else{
      while(tmp.next != head){
        if(tmp.getValue().equals(key)){
          return tmp.getCounter();
        }
        tmp = tmp.next;
      }

      if(tmp.getValue().equals(key)){
        return tmp.getCounter();
      }
    }
    return 0;
  }

  /**
  * Increments by 1 the counter associated with the specified
  * word. If the specified word is absent from the data structure,
  * a new association is created.
  *
  * @param key the specified word
  * @throws NullPointerException if the value of the parameter is null
  */

  public void update(String key) {
    if(key == null){
      throw new NullPointerException("update; Key cannot be null!");
    }

    if(head == null){
      head = new Node(key,null,null,1);
      head.next = head;
      head.previous = head;
      size++;
    }
    else{
      Node tmp = head;
      if(tmp.value.compareTo(key) > 0){
        Node n = new Node (key, tmp, tmp.previous,1);
        tmp.previous.next = n;
        tmp.previous = n;
        head = n;
        size++;
      }
      else {
        for (int i = 0; i < size; i++) {
          int com = tmp.value.compareTo(key);
          if (com == 0) {
            tmp.setCounter(tmp.getCounter()+1);
            return;
          } else if (com > 0){
            Node n = new Node(key,tmp,tmp.previous, 1);
            tmp.previous.next = n;
            tmp.previous = n;
            size++;
            return;
          }
          tmp = tmp.next;
        }

        Node n = new Node(key,tmp,tmp.previous, 1);
        tmp.previous.next = n;
        tmp.previous = n;
        size++;
      }
    }

  }
  /**
  * Returns all the keys (words) of this WordMap using their
  * natural order.
  *
  * @return all the keys (words)
  */

  public String[] keys() {
    String[] keys = new String[this.size];
    Node tmp = head;

    for(int i=0; i<size; i++){
      keys[i] = tmp.getValue();
      tmp = tmp.next;
    }
    return keys;
  }

  /**
  * Returns all the counts associated with keys in this
  * WordMap. The counts are in the same order as that of the keys
  * returned by the method keys().
  *
  * @return all the counts
  */

  public Integer[] counts() {
    Integer[] count = new Integer [this.size];
    Node tmp = head;

    for(int i=0; i<size; i++){
      count[i] = tmp.getCounter();
      tmp = tmp.next;
    }
    return count;
  }
}
