
public class Card{

  private int suit,rank;
  static final int DIAMOND=0;
  static final int CLUB=1;
  static final int HEART=2;
  static final int SPADE=3;
  public Card(int suit,int rank){
    this.suit=suit;
    this.rank=rank;
  }
  public int getSuit(){   // It returns the suit value of card.
    return suit;
  }
  public int getRank(){   // It returns the rank value of card.
    return rank;
  }
  public boolean equals ( Object object ) {  //It checks whether object is of type card or not.
    if (! (object instanceof Card)) { return false ;
    }
    Card other ;    //It checks whether the card is equal to other card.
    other = (Card) object ;
    return (this.suit==other.suit && this.rank==other.rank);
  }
  public String toString(){    //It returns the string representation of the object of card.
    return "{"+suit+","+rank+"}";

  }



}
