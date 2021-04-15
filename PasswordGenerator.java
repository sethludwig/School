/*
 * Name: Ludwig, Seth
 * Class: CMIS 242/7383
 * Date: 4/13/2021
 * Subject: Discussion-4
 * Program: PasswordGenerator.java
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGenerator extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static String finalResult;
	JFrame f;
	JButton b = new JButton("Generate");
	JTextArea area = new JTextArea();	
	
	public PasswordGenerator(){	
		setTitle("Password Generator");
		setSize(400,200);
		setLayout(null);
		setVisible(true);
		
		area.setBounds(120,50,130,20);
		area.setText("              <blank>");
		
		b.setBounds(130,100,100,40);
		b.addActionListener(this);
	
		add(area);
		add(b);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Action to perform when ActionListener is triggered on button press.
		CreatePassword();
	}
	
	public int GenerateRandomCharacterElement(int element) {
		// Generates a random number between zero and element parameter. 
		// Returns randomInteger, which determines ultimately which
		// element in the predetermined (via conditional check) array
		// is concatenated to the resulting password.
		Random randomInstance = new Random();
		int randomInteger = randomInstance.nextInt(element);		
		return randomInteger;
	}

	public int GenerateRandomArrayNumber() {
		// Generates a random number between zero and four.
		// Returns randomInteger, which determines ultimately which
		// array is selected to perform additional functionality.
		Random randomInstance = new Random();
        int randomInteger = randomInstance.nextInt(4);
        return randomInteger;
	}
	
	public void CreatePassword() {
		char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
		char[] special = {'!','@','#','$','%','^','&','*','(',')'};
		char[] lettersLower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] lettersUpper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		String[] charResult = new String[16];
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < charResult.length; i++) {
			int randomNumber = GenerateRandomArrayNumber();
			
			if (randomNumber == 0) {
				charResult[i] = String.valueOf(numbers[GenerateRandomCharacterElement(numbers.length - 1)]);
			} else if (randomNumber == 1) {
				charResult[i] = String.valueOf(special[GenerateRandomCharacterElement(special.length - 1)]);
			} else if (randomNumber == 2) {
				charResult[i] = String.valueOf(lettersLower[GenerateRandomCharacterElement(lettersLower.length - 1)]);
			} else if (randomNumber == 3) {
				charResult[i] = String.valueOf(lettersUpper[GenerateRandomCharacterElement(lettersUpper.length - 1)]);
			}
			
			sb.append(charResult[i]);	
		}
		
		finalResult = sb.toString();
		area.setText(finalResult);
	}
	
	public static void main(String[] args) {
		new PasswordGenerator();
	}
}
