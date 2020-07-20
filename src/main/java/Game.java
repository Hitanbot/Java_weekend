import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player dealer;

    public Game() {
        this.players = new ArrayList<Player>();
        this.deck = new Deck();
        deck.makeDeck();
        this.dealer = new Player("Dealer");
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addDealer(){
        addPlayer(dealer);
    }

    public void shuffleDeck(){
        deck.shuffleDeck();
    }

    public void dealCards(){
        for(int i = 0; i < players.size(); i++){
            deck.deal(players.get(i));
        }
    }

    public Player checkWinner(){
        Player winner = null;
        int currentMax = 0;
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getCardsValue() > currentMax && players.get(i).getCardsValue()<22){
                winner = players.get(i);
                currentMax = winner.getCardsValue();
            }
        }
        if (winner == null){
            winner = winner = players.get(1);
        }
        return winner;
    }

    public Deck getDeck() {
        return deck;
    }

    public void addPlayers(){
        String input = "";
        System.out.println("Enter who is playing.Type 'Done' to Begin game.");
        while(!input.equals("Done")){


            input = "";
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if(!input.contentEquals("Done")) {
                Player player = new Player(input);
                this.addPlayer(player);
            }
        }
    }

    public void addCardsBackToDeck(){
        for (int i = 0; i < players.size(); i++){
            int handSize = players.get(i).getHand().size();
            for(int j = 0; j < handSize; j++){
                deck.addCard(players.get(i).takeFirstCard());
            }


        }


    }


    public String winnerAsString(Player winner){
        ArrayList<Card> winnerHand = winner.getHand();
        return "The winner is " + winner.getName() + " with a " + winnerHand.get(0).getRank() +
                " of " + winnerHand.get(0).getSuit() + " and a " + winnerHand.get(1).getRank() +
                " of " + winnerHand.get(1).getSuit();

    }

    public void callPlayersTurns(){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(dealer)) {
                int dealerTotal = players.get(i).getCardsValue();
                if (dealerTotal < 16) {
                    Card newcard = deck.deal(players.get(i));
                }

            } else {
                String input = "";
                while (!input.equals("stick")) {
                    int currentTotal = players.get(i).getCardsValue();
                    System.out.println(players.get(i).getName() + ". Your current total is " + Integer.toString(currentTotal));
                    if (currentTotal > 21) {
                        System.out.println("You are Bust!");
                        input = "stick";
                    } else {


                        input = "";
                        System.out.println("Stick or Twist?");
                        Scanner sc = new Scanner(System.in);
                        input = sc.nextLine().toLowerCase();
                        if (input.contentEquals("twist")) {
                            Card newcard = deck.deal(players.get(i));
                            System.out.println("You drew a " + newcard.getRank() + " of " + newcard.getSuit());

                        }
                        if (!input.contentEquals("twist") && !input.contentEquals("stick")) {
                            System.out.println("Invalid Input");
                        }

                    }
                }


            }
        }


    }



}
