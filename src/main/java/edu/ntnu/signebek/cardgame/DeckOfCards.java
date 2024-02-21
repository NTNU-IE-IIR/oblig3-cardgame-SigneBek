package edu.ntnu.signebek.cardgame;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Random;

public class DeckOfCards {

  private ArrayList<PlayingCard> deck;
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private static final int deckNumbers = 13;
  private ArrayList<PlayingCard> hand;

  public DeckOfCards() {
    /* Create a deck of cards */
    this.deck = new ArrayList<>();
    this.hand = new ArrayList<>();

    for (int i = 0; i < suits.length; i++) {
      for (int j = 1; j <= deckNumbers; j++) {
        PlayingCard card = new PlayingCard(suits[i], j);
        deck.add(card);
        System.out.println(card.getAsString());
      }
    }
  }
  public void shuffle() {
    /* Shuffle the deck */

  }

  public void dealHand(int n){

    System.out.println("-------------------");
      for (int i = 0; i < n; i++) {
        int random = new Random().nextInt(deck.size());
        hand.add(deck.get(random));
        System.out.println(deck.get(random).getAsString());
        deck.remove(random);


    }

  }

}
