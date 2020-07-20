import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void makeDeck(){
        SuitType[] suits = SuitType.values();
        RankType[] ranks = RankType.values();

        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < ranks.length; j++ ){
                cards.add(new Card(suits[i], ranks[j]));
            }
        }
    }

    public int getCardsSize() {
        return cards.size();
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public Card getFirstCard(){
        return this.cards.remove(0);
    }

    public Card deal(Player player){
        Card card = this.getFirstCard();
        player.addCard(card);
        return card;
    }

    public void addCard(Card card){
        cards.add(card);
    }

}
