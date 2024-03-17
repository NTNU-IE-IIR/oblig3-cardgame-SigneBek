package edu.ntnu.signebek.cardgame;

import java.util.ArrayList;

public class CardGameController {
  private CardGameUI view;
  private DeckOfCards deckOfCards;
  private CardHand currentHand;

  public CardGameController(CardGameUI theView){
    this.deckOfCards=new DeckOfCards();
    this.view=theView;
  }

  public void dealHand(){
    this.view.setLabelBlank();
    this.currentHand = deckOfCards.dealHand(5);
    this.view.dealHand(this.currentHand.getHand());

  }

  public void checkHand(){
    ArrayList<String> heartsOnHand= this.currentHand.checkForHearts();
    int sumOfFaces=this.currentHand.checkSumOfHand();
    boolean queenOfSpades = this.currentHand.checkForQueenOfSpades();
    boolean flush = this.currentHand.checkForFlush();
    this.view.checkHand(heartsOnHand,sumOfFaces,flush,queenOfSpades);
  }
}
