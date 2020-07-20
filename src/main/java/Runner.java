import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    Game game = new Game();

    public static void main(String[] args) {

        String input = "";
        Game game = new Game();
        game.addDealer();
        game.addPlayers();
        while(!input.equals("no")){
            runGame(game);
            System.out.println("Type 'No' to quit game. Press any other key to play again.");
            input = "";
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine().toLowerCase();

        }



    }

    public static void runGame(Game game) {

        game.addCardsBackToDeck();
        game.shuffleDeck();
        game.dealCards();
        game.dealCards();
        game.callPlayersTurns();
        Player winner = game.checkWinner();

        System.out.println(game.winnerAsString(winner));

    }
}
