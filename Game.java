
package wordGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Game implements Controller{

	List<String> WordList;

	public Game() throws IOException{

		//get the list of words from the file
		BufferedReader fileReader = new BufferedReader(new FileReader("WordList.txt"));
		//create a list to store the valid words in
		WordList = new ArrayList<String>();
		//add each line to the arraylist as a new word
		String line;
		while((line = fileReader.readLine()) != null) {
			WordList.add(line);
		}
		fileReader.close();
	}

	/**
	 * Refill the tile rack with randomly selected tiles.
	 * @return the state of the tile rack
	 */
	public String refillRack() {

		//the entire alphabet and its length
		final String alphabet="abcdefghijklmnopqrstuvwxyz";
		final int noOfLetters=alphabet.length();
		Random r=new Random();

		//the array that holds the rack
		char[] rack=new char[5];

		//a loop filling the array with random characters from the alphabet
		for(int i=0;i<6;i++) {
			rack[i]=alphabet.charAt(r.nextInt(noOfLetters));
		}
		return String.valueOf(rack);
	}

	public String checkValidity(Play play, char[][] board)
	{
		//a string to hold the word being verified
		String currentword=null;
		Boolean endofword = true;
		Boolean ValidMove = true;

		//go along the gameboard array width
		for(int i = 0; i <= board[0].length; i++)
		{
			//go down the gameboard array
			for(int j = 0; j <= board.length; j++)
			{
				//if there is a letter at this position add it to the word to be checked
				if((board[i][j] != ' ') && (board[i][j] != '+'))
				{
					currentword += board[i][j];
					endofword = false;
				}
				//when the word ends check the word in the dictionary
				else if (endofword = false)
				{
					endofword = true;
					if (WordList.contains(currentword))
					{
						System.out.print("the word: " + currentword + " is invalid");
						ValidMove = false;
					}
				}				
			}
		}
		for(int i = 0; i <= board.length; i++)
		{
			//go down the gameboard array
			for(int j = 0; j <= board[0].length; j++)
			{
				//if there is a letter at this position add it to the word to be checked
				if((board[i][j] != ' ') && (board[i][j] != '+'))
				{
					currentword += board[i][j];
					endofword = false;
				}
				//when the word ends check the word in the dictionary
				else if (endofword = false)
				{
					endofword = true;
					if (!WordList.contains(currentword))
					{
						System.out.print("the word: " + currentword + " is invalid");
						ValidMove = false;
					}
				}				
			}
		}
		if (ValidMove)
		{
			return "Move is valid";
		}
		else
		{
			return "Move is Invalid";
		}
	}


	public String play(Play play,char[][] board) {
		//checking horizontal
		for (int i = 0;i <board[0].length;i++) {
			//checking vertical
			for(int j =0;j<board.length;j++) {
				//if there are empty tiles in the rack
				if(   (board[i][j] == ' ')   ||   (board[i][j] == '+')  ) {
					//getting user input(ONLY ALPHABETS)
					Scanner scanner = new Scanner (System.in);
					System.out.println("place tile");
					String input = scanner.nextLine();
					//checking users input if its equal to the Alphabets
					if(input.equals("A") ||
							input.equals("B") ||
							input.equals("C") ||
							input.equals("D") ||
							input.equals("E") ||
							input.equals("F") ||
							input.equals("G") ||
							input.equals("H") ||
							input.equals("I") ||
							input.equals("J") ||
							input.equals("K") ||
							input.equals("L") ||
							input.equals("M") ||
							input.equals("N") ||
							input.equals("O") ||
							input.equals("P") ||
							input.equals("Q") ||
							input.equals("R") ||
							input.equals("S") ||
							input.equals("T") ||
							input.equals("U") ||
							input.equals("V") ||
							input.equals("W") ||
							input.equals("X") ||
							input.equals("Y") ||
							input.equals("Z") ) {
						//if the alphabets are equal.put them in side the empty spaces
						input += board;

					}
					scanner.close();
				}
			}

		}
		//need to return state of the placed tile (working on it)
		return "hello";

	}
	public String calculateScore(Play play) {

		// Creating a Hashmap to store the letters and their values.
		HashMap<Character, Integer> pointLetter = new HashMap<Character, Integer>();
		//inputting all the letetr into the hashmap with their values
		pointLetter.put('A', 1);
		pointLetter.put('C', 1);
		pointLetter.put('D', 1);
		pointLetter.put('E', 1);
		pointLetter.put('F', 1);
		pointLetter.put('H', 1);
		pointLetter.put('I', 1);
		pointLetter.put('L', 1);
		pointLetter.put('O', 1);
		pointLetter.put('P', 1);
		pointLetter.put('R', 1);
		pointLetter.put('S', 1);
		pointLetter.put('T', 1);
		pointLetter.put('U', 1);
		pointLetter.put('V', 1);
		pointLetter.put('W', 1);

		pointLetter.put('K', 2);
		pointLetter.put('J', 2);
		pointLetter.put('B', 2);
		pointLetter.put('G', 2);
		pointLetter.put('M', 2);
		pointLetter.put('N', 2);

		pointLetter.put('Q',3);
		pointLetter.put('X', 3);
		pointLetter.put('Y',3);
		pointLetter.put('Z', 3);
		
		return null;
	}

	public static int calculateScore(String gameWord) {
		int total = 0;
		for(int i = 0; i <gameWord.length();i++) {
			//this looks up the current char in the hashmap 'pointLetter' and add it's value to total
			total += pointLetter.get(gameWord.charAt(i));
		}
		return total;
	}


}

