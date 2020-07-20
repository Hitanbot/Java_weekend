import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private String name;
    private Boolean hasAce;

    public Player(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.hasAce = false;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getCardsValue(){
        int total = 0;
        hasAce = false;
        for(int i = 0; i < hand.size(); i++){
            if (hand.get(i).getRank().equals(RankType.ACE)){
                hasAce=true;
            }
            total += hand.get(i).getRank().getValue();
        }
        if (hasAce && total+10<22){
            total+=10;
        }
        return total;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }


    public Card takeFirstCard(){
        return this.hand.remove(0);
    }


}
