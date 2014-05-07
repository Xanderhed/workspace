import java.util.Scanner;

public class player {
	public String name;
	public int wallet = 2000;
	
	player (){
		Scanner myName = new Scanner(System.in);
		name = myName.next();
	}
	
	public void printName(){
		System.out.println(name);
	}
	public void getBalance(){
		System.out.println(wallet);
	}
	public void walletOperation(int money){
		wallet = wallet + money;
	}
}
