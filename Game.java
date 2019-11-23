
package wordGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Game implements Controller{
	
	public Game() throws IOException{
		
		//get the list of words from the file
		BufferedReader fileReader = new BufferedReader(new FileReader("WordList.txt"));
		//create a list to store the valid words in
		List<String> WordList = new ArrayList<String>();
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
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		int noOfLetters=alphabet.length();
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
		String currentword;
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
					if (WordList[].))
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

}

