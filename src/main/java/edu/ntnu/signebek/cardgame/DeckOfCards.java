package edu.ntnu.signebek.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

  private ArrayList<PlayingCard> deck;
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private static final int deckNumbers = 13;

  public DeckOfCards() {
    this.deck = new ArrayList<>();

    for (int i = 0; i < suits.length; i++) {
      for (int j = 1; j <= deckNumbers; j++) {
        PlayingCard card = new PlayingCard(suits[i], j);
        deck.add(card);
      }
    }
    shuffle();
  }

  public void shuffle() {
    List<PlayingCard> listDeck= new ArrayList<>(this.deck);
   Collections.shuffle(listDeck);
  }

  public CardHand dealHand(int n){
    try {
      if (deck.size()<n){
        throw new IllegalArgumentException("Deck has less than "+n+" cards. Cannot deal to hand.");
      }
      ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
      for (int i = 0; i < n; i++) {
        int random = new Random().nextInt(deck.size());
        hand.add(deck.get(random));
        deck.remove(random);
      }
      return new CardHand(hand);

    } catch (Exception e){
      return new CardHand(new ArrayList<PlayingCard>());
    }
  }
}
