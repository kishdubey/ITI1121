

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

  private ArrayList<Card> cards;

  /**
  * A constructor for the class <code>Deck</code>. It creates the initial
  * <code>ArrayList</code> that will be used to store the cards of Otherwise
  * deck.
  */

  public Deck() {
    cards = new ArrayList<Card>();

  }

  /**
  * A constructor for the class <code>Deck</code>. It creates the initial
  * <code>ArrayList</code> that will be used to store the cards of Otherwise
  * deck. The parameter specifies the number of ranks for the cards. Finally,
  * it also initializes this deck to contain 4 x n cards, where n is the value
  * of the parameter.
  *
  * @param range the number of ranks for the cards
  */


  public Deck(int range) {

    // Complete the implementation of this constructor
    cards = new ArrayList<Card>();  // store the cards of this deck.
    for (int i=0;i<=3;i++)
    {
      for (int j=1;j<=range;j++){
        cards.add(new Card(i,j));
      }

    }

  }


  // Add all the necessary methods here
  public int size(){  //returns the size of card
    return cards.size();
  }

  public boolean hasCards(){  //return card deck has cards inside it or not.
    return(cards.size()>0);

  }
  public Card get(int pos){ // returns the card at the specified position in the deck.
    return(cards.get(pos));}

    public void add(Card card){ //adds the specified card at the end of this deck.
      cards.add(card);
    }
    public void addAll(Deck other){  //appends all the cards from other at the end of this deck. cards are removed from the other deck.
      while(other.cards.size()>0)
      {
        int index = other.cards.size()-1;
        cards.add(other.get(index));
        other.cards.remove(index);
      }

    }
    public Card removeLast(){    //removes and returns the last card of this deck.

      return (cards.remove(cards.size()-1));

    }
    public Card removeFirst(){     //removes and returns the first card of this deck.

      return (cards.remove(0));



    }
    public boolean remove(Card card){   //removes the first occurrence of the specified card from this deck.
      for (int i=0;i<cards.size();i++)
      {
        if (cards.get(i).equals(card)){
          cards.remove(i);
          return true;
        }
      }
      return false;

    }
    public void removeAll(Deck other){  // removes from this deck all of its cards at are contained in the deck by the other deck.
      for (int i=0;i<cards.size();i++)
      {
        if (cards.get(i).equals(other)){
          cards.remove(i);

        }
      }

    }
    public void shuffle(){         //shuffle the current deck.
      Collections.shuffle(cards);
    }
    public Deck deal(int n){     // removes a maximum of n cards from the end of this deck.
      Deck deal=new Deck();
      int cardCounter = n;
      while(cardCounter > 0){

        deal.add(cards.get(cards.size() - 1));
        this.removeLast();
        cardCounter--;
      }
      return deal;
    }
    public boolean contains(Card card){    //returns boolean whether cards has current card or not.
      for (int i=0;i<cards.size();i++){
        if(cards.get(i).equals(card))
        {return true;}
      }return false;
    }
    public boolean containsAll(Deck other){ //returns boolean if this deck contains all the cards in the specified other deck.
      for(int i =0; i<other.cards.size(); i++){
        if(!(cards.contains(other.get(i))))
        {return false;}
      }return true;
    }
    public boolean isKind(){ //returns boolean if deck has at least two cards and all the cards have the same rank.
      if (cards.size()>1){
        for(int i=0; i<cards.size()-1; i++){
          if(!(cards.get(i).getRank()==(cards.get(i+1).getRank()))){
            return false;
          }

        }
        return true;
      }
      return false;


    }
    public boolean isSeq(){  // returns boolean if deck has at least three cards, the cards all have the same suit, the cards form a sequence of consecutive ranks.
      for (int i=0;i<cards.size()-1;i++){
        if(!(cards.get(i).getSuit() == cards.get(i + 1).getSuit() && cards.get(i + 1).getRank() - cards.get(i).getRank() == 1)){
          return false;
        }
      }
      return true;

    }

    public void sortBySuit(){  //it sorts the deck by suit.

      ArrayList<Card> sorter = new ArrayList<Card>();

      for(int x=cards.size();x>0;x--)
      {
        int a = 0;
        Card c = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
          Card d = cards.get(i);
          if (d.getSuit() < c.getSuit() ||(d.getSuit() == c.getSuit() && d.getRank() < c.getRank())) {
            a = i;
            c = d;
          }
        }
        sorter.add(c);
        cards.remove(a);
      }
      cards = sorter;


    }

    public void sortByRank(){  //it sorts the deck by rank.
      ArrayList<Card> sorter = new ArrayList<Card>();

      for(int x=cards.size();x>0;x--){
        int a=0;
        Card c = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
          Card d = cards.get(i);
          if ( d.getRank() < c.getRank() ||(d.getRank() == c.getRank() && d.getSuit() < c.getSuit())) {
            a = i;
            c = d;
          }
        }
        sorter.add(c);
        cards.remove(a);
      }
      cards = sorter;

    }
    public void print(){ //it prints the deck in two ways,first sorted by suit and then rank.
      sortBySuit();
      System.out.println(cards);
      sortByRank();
      System.out.println(cards);


    }

    public String toString(){//it represents the string representation of card deck.
      return "{"+cards+"}";

    }

  }
