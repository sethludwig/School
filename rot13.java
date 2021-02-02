/*
 * Name: Ludwig, Seth
 * Class: CMIS 141/6381
 * Date: 2/1/2021
 * Subject: Discussion 3
 * Program: rot13.java
 */

// Import java.util.Scanner library.
// Import java.land.StringBuilder library.
import java.util.Scanner;
import java.lang.StringBuilder;

public class rot13 {

	public static void main(String[] args) {
		
		// Program Banner
		String banner = """

  ad8888888888ba
 dP\'         \'\"8b,
 8  ,aaa,       \"Y888a     ,aaaa,     ,aaa,  ,aa,
 8  8\' \'8           \"88baadP\"\"\"\"YbaaadP\"\"\"YbdP\"\"Yb
 8  8   8              \"\"\"        \"\"\"      \"\"    8b
 8  8, ,8         ,aaaaaaaaaaaaaaaaaaaaaaaaddddd88P
 8  \'\"\"\"\'       ,d8\"\"
 Yb,         ,ad8\"        ROT-13 Encoder / Decoder
  \"Y8888888888P\"               Discussion - Week 3
                                       Seth Ludwig
  ----------------------------------------------------
  ROT13 is a special case of the encryption algorithm 
  known as a Caesar cipher, used by Julius Caesar in 
  the 1st century BC. 
  
  Applying ROT13 to a piece of text merely requires 
  examining its alphabetic characters and replacing 
  each one by the letter 13 places further along in 
  the alphabet, wrapping back to the beginning if 
  necessary.
  
  This program will strip all spaces from user message
  input, to simplify program logic.
  ----------------------------------------------------
						""";
		
		// Display banner
		System.out.print(banner);
		
		// Prompt user for input, declare and define 'message'.
		Scanner inputMessage = new Scanner(System.in);
		System.out.print("\n[+] Enter your (alphabetic only) secret message here: ");
		String message = inputMessage.nextLine();
		
		// Strip all spaces from user input.
		String clean = message.replaceAll("\\s+", "");
		
		// Create new instance of StringBuilder.
		StringBuilder builder = new StringBuilder();
		
		// Parse 'clean' with rot13 cipher.
		// Append each shifted character to 'builder' StringBuilder.
		// Adapted from https://stackoverflow.com/questions/8981296/rot-13-function-in-java
		for (int i = 0; i < clean.length(); i++) {
			char character = clean.charAt(i);
			if (character >= 'a' && character <= 'm') {
				character += 13;
			}
			else if (character >= 'A' && character <= 'M') {
				character += 13;
			}
			else if (character >= 'n' && character <= 'z') {
				character -= 13;
			}
			else if (character >= 'N' && character <= 'Z') {
				character -= 13;
			}

			builder.append(character).append("");
	
		}
		
		// Convert StringBuilder 'builder' to string and display result.
		String result = builder.toString();
		System.out.println("\n[+] Result: " + result);

	}

}
