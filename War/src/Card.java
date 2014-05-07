public class Card {
	public String suit;
	public int value;
	public boolean dealt;
	
	Card(String Suit, int Value){
		suit = Suit;
		value = Value;
		dealt = false;
	}
	
	public void getCard(){
		if(value < 10){
			System.out.print(value+1 + " of " + suit);
		}
		else if(value == 10){
			System.out.print("Jack of " + suit);
		}
		else if(value == 11){
			System.out.print("Queen of " + suit);
			
		}
		else if(value == 12){
			System.out.print("King of " + suit);
		}
		else if(value == 13){
			System.out.print("Ace of " + suit);
		}
	}
	public void deal(){
		dealt = true;
	}
}
