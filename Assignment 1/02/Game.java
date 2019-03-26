

import java.util.ArrayList;
import java.util.Collections;

public class Game{ //the game object has two deck i.e. main deck and players deck.
  private Deck deck;
  private Deck playerdeck;
  private Die d;
  private Utils util;
  private int counter=0;
  public Game(int rank){
    deck = new Deck(rank);
    playerdeck = new Deck();
    d = new Die();
  }
  /*
  the method play implements the rummy game logic.
  first player is dealt with seven cards.then die is rolled.
  If die value is equal to 1,it can discard one card of the choice from the players deck.
  If die value is 2,3,4,5,6 it ask the user if it has melds of atleast 2 cards of same kind or atleast 3 cards forming a sequence of same suit.
  it also checks for the validity of the card and whether that cards form a meld or not.
  Finally if main deck is empty the die is set to 1 and players can discard one card of the choice from the players deck.
  Finally after each discard round is over.
  Lastly when player deck is empty ,final rounds are reported and game gets over.

  */
  public void play(){
    //Game code...
    Utils util=new Utils();

    deck.shuffle();


    playerdeck = deck.deal(7);
    playerdeck.print();

    while(playerdeck.size()!=0)
    {if(deck.hasCards()==true){
      d.roll();
      System.out.println("You have rolled a "+d.getValue());

      counter++;
      int dieRoll = d.getValue();
      if(dieRoll==1)
      {

        playerdeck.remove(util.readCard());
        System.out.println("Round "+counter+" has been completed.");


      }
      else
      {int x=Math.min(deck.size(), dieRoll);

        playerdeck.addAll(deck.deal(x));
        playerdeck.print();

        Deck read = new Deck();

        while(util.readYesOrNo("Do you have melds")==true){
          read = util.readCards("Enter your melds: ");
          if(playerdeck.containsAll(read)){
            if(read.size()>=2)
            {
              if((read.isKind()||(read.isSeq()&&read.size()>2)))
              {
                for (int zz=0;zz<read.size()-1;zz++)
                {playerdeck.remove((read.get(zz)));
                  playerdeck.remove((read.get(zz+1)));}

                  playerdeck.print();

                }
                else{System.out.println(" is not a meld");
              }
            }
            else{System.out.println(" Enter atleast 2 cards for meld or 3 cards for a progression");}
          }
          else{System.out.println(" Card not present");
        }

      }
      System.out.println("Round "+counter+" has been completed.");
      System.out.println("Here is your new deck");
      playerdeck.print();



    }
  }
  else
  
  {
    for(int i=0;i<=playerdeck.size();i++){
      int dieRoll=1;
      counter++;
      System.out.println("Youe deck is empty");
      System.out.println("You have rolled a "+dieRoll);

      Card e=util.readCard();
      if((playerdeck.contains(e))&&(e.getRank()>0)){
        playerdeck.remove(e);
        System.out.println("Round "+counter+" has been completed.");
        System.out.println("Here is your new deck");
        playerdeck.print();
      }else{

        boolean a=true;
        while(a==true){
          if(a==true){
            while(playerdeck.contains(e)==false){

              System.out.println("Enter correct card");
              e=util.readCard();
              if(playerdeck.contains(e)==true){
                a=false;
                break;
              }

            }
            playerdeck.remove(e);}
          }
          System.out.println("Round "+counter+" has been completed.");
          System.out.println("Here is your new deck");
          playerdeck.print();

        }

      }

    }

}

System.out.println("Congratulations, you have finished the game. It took "+counter+" rounds.");
}

}
