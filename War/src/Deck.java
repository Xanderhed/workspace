import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>();
	
	Deck(){
		for(int i=1; i<=13; i++){
			deck.add(new Card("Spades",i));
		}
		for(int i=1; i<=13; i++){
			deck.add(new Card("Clubs",i));
		}
		for(int i=1; i<=13; i++){
			deck.add(new Card("Hearts",i));
		}
		for(int i=1; i<=13; i++){
			deck.add(new Card("Diamonds",i));
		}
	}
	public void deal(Player player1, Player player2){
		Random random = new Random();
		int seed = 0;
		for(int i=0; i<52;){
			seed = Math.abs(random.nextInt()%52);
			if (deck.get(seed).dealt){
				continue;
			}
			else {
				if (i%2 < 1){
					player1.drawCard(deck.get(seed));
					i++;
					continue;
				}
				else {
					player2.drawCard(deck.get(seed));
					i++;
					continue;
				}
			}
		}
	}
}
