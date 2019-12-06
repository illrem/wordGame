
package wordGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Game implements Controller{
        
	private HashMap<Character, Integer> pointLetter; 
	private List<String> WordList;
	private char[][] gameBoard;
	private char[] rack;

	public Game() throws IOException{
                //hashmap to store the letters and thier values.
		pointLetter = new HashMap<Character, Integer>();
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
		
		//the array that holds the rack
		rack=new char[5];
				
		//2d array that holds the game board
		gameBoard=new char[10][10];
		
		//filling the board 
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[i].length;i++) {
				if( ((i==4 || i==5) && (j==1 || j==8)) ||
					((i==3 || i==6) && (j==3 || j==6))) {
					
					gameBoard[i][j]='+';
				}
				else {
					gameBoard[i][j]='-';
				}
			}
		}
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

		//a loop filling the array with random characters from the alphabet
		for(int i=0;i<6;i++) {
			rack[i]=alphabet.charAt(r.nextInt(noOfLetters));
		}
		return String.valueOf(rack);
	}
	
	/**
	 * Return the current state of the game board and the contents of the player's tile rack
	 * as a String object.
	 * @return the current state of the game board and the contents of the player's tile rack
	 * as a String object
	 */
	public String gameState() {
		String lineSeparator = System.lineSeparator();
		StringBuilder builder = new StringBuilder();

		for (char[] row : gameBoard) {
		    builder.append(Arrays.toString(row))
		      .append(lineSeparator);
		}

		String result = builder.toString();
		return result + '\n' + "tile rack: "+String.valueOf(rack);
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
		//inputting all the letters into the hashmap with their values
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
		
	//this is where the letters on the rack are stored
   String letterPositionsInRack = play.letterPositionsInRack();
   String gameWord = ""; 
          int total = 0;
          
          // going through the 5 letters on the rack
     for(int i = 0; i <letterPositionsInRack.length();i++) {
 
    	char position = letterPositionsInRack.charAt(i);
    	 total += pointLetter.get(rack[position]);
        gameWord= gameWord + "" + rack[position];
  
     }   
     // if the letters are placed on anuy of the following tiles then the player will get double points
     if(gameBoard[4][1] == '+' || gameBoard[5][1] == '+' || gameBoard[3][3] == '+' || gameBoard[6][3] == '+' ||
    		 gameBoard[3][6] == '+'|| gameBoard[4][8] == '+'||  gameBoard[5][8] == '+' || gameBoard[6][6] == '+') {
    	 
    	 //double points
    	 
     }
     
  //String returning the points
     return ("Word: " + gameWord + "  The Word scores: " + total);
     }
	

}

