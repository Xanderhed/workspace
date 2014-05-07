import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	
	public static void gameStatus(Player player1, Player player2){
		System.out.println(player1.name + ": " + player1.hand.size() + " cards");
		System.out.println(player2.name + ": " + player2.hand.size() + " cards");
	}
	
	public static void battle(Player player1, Player player2, ArrayList <Card> cardHolder){
		System.out.println();
		System.out.print(player1.name + ": ");
		player1.hand.get(0).getCard();
		System.out.println();
		System.out.print(player2.name + ": ");
		player2.hand.get(0).getCard();
		System.out.println();
		if (player1.hand.get(0).value == player2.hand.get(0).value){
			System.out.println("WAR!");
			for(int i = 0; i<=3; i++){
				cardHolder.add(player1.hand.get(0));
				cardHolder.add(player2.hand.get(0));
				player1.playCard();
				player2.playCard();
				if (player1.hand.size() == 0 || player2.hand.size() == 0){
					break;
				}
			}
			if (player1.hand.size() != 0 && player2.hand.size() != 0){
				battle(player1, player2, cardHolder);
			}
		}
		else if(player1.hand.get(0).value > player2.hand.get(0).value){
			System.out.println(player1.name + " wins!");
			cardHolder.add(player1.hand.get(0));
			cardHolder.add(player2.hand.get(0));
			player1.playCard();
			player2.playCard();
			while(cardHolder.size()>0){
				player1.drawCard(cardHolder.get(0));
				cardHolder.remove(0);
			}
		}
		else if(player2.hand.get(0).value > player1.hand.get(0).value){
			System.out.println(player2.name + " wins!");
			cardHolder.add(player1.hand.get(0));
			cardHolder.add(player2.hand.get(0));
			player1.playCard();
			player2.playCard();
			while(cardHolder.size()>0){
				player2.drawCard(cardHolder.get(0));
				cardHolder.remove(0);
			}
		}
	}
	
	public static void main(String[] args) {
		//Create the game deck
		Deck gameDeck = new Deck();
		ArrayList <Card> cardHolder = new ArrayList <Card>();
		Scanner input = new Scanner(System.in);
		//Create the two players
		System.out.println("Name player 1");
		Player player1 = new Player(input.next());
		System.out.println("Name player 2");
		Player player2 = new Player(input.next());
		//Deal out the cards in the deck
		gameDeck.deal(player1, player2);
		gameStatus(player1, player2);
		while(player1.hand.size() != 0 && player2.hand.size() != 0){
			battle(player1, player2, cardHolder);
			gameStatus(player1, player2);
		}
		input.close();
	}

}
