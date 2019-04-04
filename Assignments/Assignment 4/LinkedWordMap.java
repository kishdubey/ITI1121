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
  public LinkedWordMap(){
    head = null;
    tail = null;
    size = 0;
  }

  // private boolean isEmpty(){
  //   return head==null;
  // }

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

  private boolean isEmpty(){
    if(size==0){
      return true;
    }
    return false;
  }

  public void deleteAtPos(int pos)
    {
        if (pos == 1)
        {
            if (size == 1)
            {
                head = null;
                tail = null;
                size = 0;
                return;
            }
            head = head.getLinkNext();
            head.setLinkPrev(tail);
            tail.setLinkNext(head);
            size--;
            return ;
        }
        if (pos == size)
        {
            tail = tail.getLinkPrev();
            tail.setLinkNext(head);
            head.setLinkPrev(tail);
            size-- ;
        }
        Node ptr = head.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

  private void insertAtStart(String s){
    Node nptr = new Node(s, null, null, 1);
    if(head == null){
      nptr.setLinkNext(nptr);
      nptr.setLinkPrev(nptr);
      head = nptr;
      tail = head;
    } else {
      nptr.setLinkPrev(tail);
      tail.setLinkNext(nptr);
      head.setLinkPrev(nptr);
      nptr.setLinkNext(head);
      head = nptr;

    }
    size++;
  }

  private void insertAtEnd(String s){
    Node nptr = new Node(s, null, null, 1);
    if (head == null)
    {
      nptr.setLinkNext(nptr);
      nptr.setLinkPrev(nptr);
      head = nptr;
      tail = head;
    }
    else
    {
      nptr.setLinkPrev(tail);
      tail.setLinkNext(nptr);
      head.setLinkPrev(nptr);
      nptr.setLinkNext(head);
      tail = nptr;
    }
    size++;
  }

  private void insertAtPos(String s, int pos){
    Node nptr = new Node(s, null, null, 1);
    if (pos == 1)
    {
      insertAtStart(s);
      return;
    }
    Node ptr = head;
    for (int i = 2; i <= size; i++)
    {
      if (i == pos)
      {
        Node tmp = ptr.getLinkNext();
        ptr.setLinkNext(nptr);
        nptr.setLinkPrev(ptr);
        nptr.setLinkNext(tmp);
        tmp.setLinkPrev(nptr);
      }
      ptr = ptr.getLinkNext();
    }
    size++;
  }

  private void sortedInsert(String s){
    int pos = 0;
    Node tmp = head;
    boolean flag = false;
    boolean flag1 = false;

    if(isEmpty()){
      insertAtStart(s);
      flag = true;
    }

    if(!flag){
      while(tmp.next != head){
        pos++;
        if(s.compareTo(tmp.getValue()) < 0){
          if(tmp == head){
            insertAtStart(s);
            flag1 = true;
          }
          else{
            flag1 = true;
            insertAtPos(s, pos);
          }
        }
          tmp = tmp.next;

      }
    }

      if(!flag1 && !flag){
      if(s.compareTo(tmp.getValue()) < 0){
        insertAtPos(s, pos);

      }
      insertAtEnd(s);
    }
  }


  public void update(String key) {

    if(key == null){
      throw new NullPointerException();
    }

    Node tmp = head;
    boolean flag = false;

    if(contains(key)){
      while(tmp.next!=head){
        if(tmp.getValue().equals(key)){
          tmp.setCounter(tmp.getCounter()+1);
          flag = true;
          break;
        }
        tmp = tmp.next;
      }

      if(tmp.getValue().equals(key) && !flag){
        tmp.setCounter(tmp.getCounter()+1);
      }
    }else{
      sortedInsert(key);
    }
  }
  /**
  * Returns all the keys (words) of this WordMap using their
  * natural order.
  *
  * @return all the keys (words)
  */

  public String[] keys() {
    String[] keyy = new String [this.size];
    Node tmp = head;
    int i = 0;

    while(tmp.next!=head){
      keyy[i] = tmp.getValue();

      i++;
      tmp = tmp.next;
    }
    return keyy;
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
    int i = 0;

    while(tmp.next!=head){
      count[i] = tmp.getCounter();
      i++;
      tmp = tmp.next;
    }
    return count;
  }
}
