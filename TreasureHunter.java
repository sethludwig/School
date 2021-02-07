/*
 * Name: Ludwig, Seth
 * Class: CMIS 141/6381
 * Date: 2/6/2021
 * Subject: Discussion 4
 * Program: TreasureHunter.java
 */

// Import libraries.
import java.util.InputMismatchException;
import java.util.Scanner;

// TreasureHunter class.
public class TreasureHunter {

	// Create banner.
	static String banner = """
                        _________
                     _ /_|_____|_\\ _
                       '. \\   / .'
                         '.\\ /.'
                           '.'
                   _.-^^---....,,---_
                _--                  --_
               <      TreasureHunter    >)
                \\._   Discussion 4    _./
                   ```--. . , ; .--'''
                         | |   |
                      .-=||  | |=-.
                      `-=#$%&%$#=-'
                         | ;  :|
                  ___.,-#%&$@%#&#~,._____
--------------------------------------------------------------
Dear Tenant,

Rent is due and you owe me 100 coins. You can find some spare 
coins buried beneath a mine-field in the backyard. 

Good luck!

-The Crazy Landlord
--------------------------------------------------------------
					""";
	// Declare, define, and initialize 'coins' and 'health'.
	static int coins = 0;
	static int health = 100;
	
	// Create 'dig' method. Basically just a random number generator. Returns 'random' to method caller.
	static int dig() {
		int min = 1;
		int max = 15;
		
		// Use Math.random() to generate random number and assign value to 'random'.
		int random = (int)(Math.random() * (max - min + 1) + min);
		return random;
	}

	// Create a method to check if we 'hit a mine'. Essentially creates a 50% chance of hitting a mine or not,
	// using a random number between 0 and 1. Returns the output to the method caller.
	static int check() {
		int min = 0;
		int max = 1;
		// Use Math.random() to generate random number and assign value to 'random'.
		int random = (int)(Math.random() * (max - min + 1) + min);
		return random;
	}
	
	// Create 'getHealth' method to accept input for parameter 'newHealth', return the value of 'health' to
	// method caller.
	static int getHealth(int newHealth) {
		health = newHealth;
		return health;
	}
	
	// Create 'setHealth' method to update the 'health' variable each time it is called.
	static int setHealth() {
		int oldHealth = health;
		int newHealth = oldHealth - 10;
		getHealth(newHealth);
		return newHealth;
	}
	
	// Create 'getCoins' method to accept input for parameter 'newCoins', return the value of 'coins' to 
	// method caller.
	static int getCoins(int newCoins) {
		int found = dig();
		System.out.println("[+] You dig a hole. You find " + found + " coins.");
		coins = newCoins + found;
		return coins;
	}
	
	// Create 'setCoins' method to update the 'coins' variable each time it is called.
	static int setCoins() {
		int oldCoins = coins;
		int newCoins = oldCoins;
		getCoins(newCoins);
		return newCoins;
	}
	
	// The main method.
	public static void main(String[] args) {

		// Display program banner.
		System.out.println(banner);
		
		// Prompt user for input, declare and define 'holes'.
		// Wrapped in exception handler for invalid input.
		try {
		Scanner inputHoles = new Scanner(System.in);
		System.out.print("[+] How many holes would you like to dig? : ");
		int holes = inputHoles.nextInt();

		if (holes == 0) {
			System.out.println("\n[X] <insert spongebob's \"iight, imma head out\" meme>\n");
		}
		
		// While loop, running 'holes' number of iterations. At the end of each iteration,
		// decrease 'holes' by one. Will only continue the while loop if 'health' is greater
		// than 0, 'coins' is less than 100, and 'holes' is greater than 0.
		while (holes > 0) {
			
			// Conditional check to see if we hit a mine by performing a boolean conditional check
			// against the 'check()' method. The 'check()' method will return either 0 or 1, randomly.
			// If the boolean condition returns true, the 'setHealth()' method is called. The 'setHealth()' 
			// method reduces overall health by 10 each time it is triggered.
			if (check() == 1) {
				setHealth();
				String resultCoins = String.valueOf(coins);
				String resultHealth = String.valueOf(health);
				System.out.println("\n--------------------------------------------------------------");
				System.out.println("[***] Your shovel struck a buried mine, ouch![***]");
				System.out.println("[!] You have " + resultHealth + " health remaining.");
				System.out.println("[!] You have " + resultCoins + " coins total.");
				System.out.println("--------------------------------------------------------------");


			} else {
				// Calls the 'setCoins' method, if we didn't hit a mine.
				setCoins();
			}
			
			// Decrement 'holes' by 1 for each iteration of the while loop.
			holes = holes - 1;
			
			// Conditional check. If 'holes' is equal to zero, coins is less than 100, and health is greater than
			// zero, prompt user for continue.
			if (holes == 0 && coins < 100 && health > 0) {
				// Prompt user for input, declare and define 'digMore'.
				Scanner inputContinue = new Scanner(System.in);
				System.out.print("\n[+] Keep digging? (y/n) : ");
				String digMore = inputContinue.next();
				
				// Conditional check. If 'digMore' contains 'y', prompt for how many more holes they wish to dig.
				if (digMore.contains("y")) {
					Scanner inputHolesContinue = new Scanner(System.in);
					System.out.print("[+] How many holes would you like to dig? : ");
					holes = inputHolesContinue.nextInt();
					
					// If user input does not contain 'y' character, break loop and end program.
				} else {
					System.out.println("[X] You no longer have the will to continue digging and decide to walk away.");
					break;
				}
				
			}
			
			// Conditional check. If health is equal to 0, you lose.
			if (health == 0) {
				System.out.println("\n--------------------------------------------------------------");
				System.out.println("[!] You found a few too many mines...");
				System.out.println("--------------------------------------------------------------\n");
				System.out.println("[X] You no longer have the will to continue digging and decide to walk away.");
				break;
			}
			
			// Conditional check. If coins meets or exceeds 100, you win!
			if (coins >= 100) {
				System.out.println("\n--------------------------------------------------------------");
				System.out.println("[!] You have collected " + coins + " coins!");
				System.out.println("--------------------------------------------------------------\n");
				System.out.println("Dear Tenant,\n\nThank you for collecting my rent money. See you next month!\n\n-The Crazy Landlord");
				break;
			}
		}
		
		// Exception handler. Catches invalid input and terminates program.
		}catch(InputMismatchException e) {
			System.out.println("Invalid input. Exiting.");
		}
		
	}

}
