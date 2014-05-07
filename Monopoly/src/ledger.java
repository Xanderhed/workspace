import java.util.Scanner; 
import java.util.ArrayList;

public class ledger {
	// Populates the roster
	static void populate(int size, ArrayList<player> roster){
		for (int i=0; i < size; i++){
			System.out.println("Please name player " + (i+1));
			roster.add(new player());
		}
	}
	// Displays the current players and their wallets
	static void gameStatus(int competitors, ArrayList<player> roster){
		for (int i = 0; i < competitors; i++){
			System.out.println((i+1) + "." + roster.get(i).name + "    $" + roster.get(i).wallet);
		}
	}
	static void printOptions(int index, ArrayList<player> roster){
		System.out.println("Did " + roster.get(index).name);
		System.out.println("1. have to pay rent");
		System.out.println("2. conduct another transaction");
		System.out.println("3. get eliminated");
	}
	public static void main(String[] args) {
		int numPlayers = 0;
		int playerNumber = 0;
		int money = 0;
		// Ask how many players there are
		System.out.println("How many players are there?");
		// Get input on number of players
		Scanner scanner = new Scanner(System.in);
		numPlayers = scanner.nextInt();
		// Create an array list of players
		ArrayList<player> roster = new ArrayList<player>();
		// Populate the array list of players
		populate(numPlayers, roster);
		// Start the game
		while (roster.size() > 1){
			gameStatus(roster.size(), roster);
			System.out.println("Number of player");
			scanner = new Scanner(System.in);
			playerNumber = scanner.nextInt() - 1;
			printOptions(playerNumber, roster);
			scanner = new Scanner(System.in);
			if (scanner.nextInt() == 1){
				System.out.println("How much?");
				scanner = new Scanner(System.in);
				money = scanner.nextInt();
				roster.get(playerNumber).walletOperation(-money);
				System.out.println("To whom?");
				gameStatus(roster.size(), roster);
				scanner = new Scanner(System.in);
				playerNumber = scanner.nextInt() - 1;
				roster.get(playerNumber).walletOperation(money);
			}
			if (scanner.nextInt() == 2){
				System.out.println("What was the balance change?");
				scanner = new Scanner(System.in);
				money = scanner.nextInt();
				roster.get(playerNumber).walletOperation(money);
			}
			else if (scanner.nextInt() == 3){
				roster.remove(playerNumber);
			}
		}
		System.out.println("Game over! The winner is " + roster.get(0).name + ".");
		scanner.close();
	}
}
