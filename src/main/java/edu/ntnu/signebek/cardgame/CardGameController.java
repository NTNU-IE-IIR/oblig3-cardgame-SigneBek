package edu.ntnu.signebek.cardgame;

import java.util.ArrayList;

public class CardGameController {
  private CardGameUI view;
  private DeckOfCards deckOfCards;

  public CardGameController(CardGameUI theView){
    this.deckOfCards=new DeckOfCards();
    this.view=theView;
  }
  public void dealHand(){
    this.view.dealHand(deckOfCards.dealHand(5));
    //TODO make a hand class?
  }
}
