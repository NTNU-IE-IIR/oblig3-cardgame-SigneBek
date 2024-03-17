package edu.ntnu.signebek.cardgame;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CardHand {

  private ArrayList<PlayingCard> hand;

  public CardHand(ArrayList<PlayingCard> hand){

    this.hand=hand;
  }

  public int checkHandSize(){

    return this.hand.size();
  }

  public int checkSumOfHand(){
    int sum = this.hand
        .stream()
        .mapToInt((PlayingCard card)->{
          return card.getFace();}) //Returns the sum of the card
        .sum(); //Sums all the cards on hand
    return sum;
  }

  public ArrayList<String> checkForHearts(){
    ArrayList<String> hearts = this.hand
        .stream()
        .filter( (PlayingCard card) -> card.getAsString().contains("H")) //Filters out all cards that do not contain "H"
        .map(PlayingCard::getAsString) //Sets the cards to a string
        .collect(Collectors.toCollection(ArrayList::new)); //Collects them and adds them to an arraylist
    return hearts;
  }

  public boolean checkForQueenOfSpades(){
    boolean check = this.hand
        .stream()
        .anyMatch((PlayingCard card) -> {
          return card.getAsString().equals("S12"); //Sets check too true if there is a card that equals "S12"
        });
    return check;

  }

  public boolean checkForFlush(){
    return this.hand
        .stream()
        .map((PlayingCard card) -> {
          return card.getSuit(); //Sets the cards to the suit
        })
        .collect(Collectors.groupingBy((Character suit) -> {
          return suit.charValue(); //Groups them into collections based on suit
        }, Collectors.counting())) //Counts the number of objects in that collection
        .values()
        .stream() //New stream
        .anyMatch(c -> c >= 5); //Returns true if one of the collections have 5 or more objects
  }

  public ArrayList<PlayingCard> getHand(){

    return hand;
  }


}
