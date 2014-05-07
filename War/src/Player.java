import java.util.ArrayList;

public class Player {
	public String name;
	public ArrayList<Card> hand = new ArrayList<Card>();
	
	Player (String callSign){
		name = callSign;
	}
	
	public void drawCard(Card gain){
		hand.add(gain);
	}
	public Card playCard(){
		Card played = hand.get(0);
		hand.remove(0);
		return played;
	}
	
	public void handSize(){
		System.out.print(hand.size());
	}
}
