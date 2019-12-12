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

public class Game implements Controller{

	private HashMap<Character, Integer> pointLetter; 
	private List<String> WordList;
	private char[][] gameBoard;
	private char[] rack;

	public Game() throws IOException{

		//hash-map to store the letters and their values.
		pointLetter = new HashMap<Character, Integer>();
		//get the list of words from the file
		BufferedReader fileReader = new BufferedReader(new FileReader("C://Users//rgold//OneDrive//Documents//Uni work//cs2310//wordGameTest//src//wordGameTest//WordList.txt"));
		//create a list to store the valid words in
		WordList = new ArrayList<String>();
		//add each line to the array-list as a new word
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
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
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
		for(int i=0;i<5;i++) {
			int posLetter=r.nextInt(noOfLetters);
			rack[i]=alphabet.charAt(posLetter);
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
		
		//allows for board to made as a model
		for (char[] row : gameBoard) {
			builder.append(Arrays.toString(row))
			.append(lineSeparator);
		}
		
		//stores board as string
		String result = builder.toString();
		//returns board and the rack
		return result + '\n' + "tile rack: "+String.valueOf(rack);
	}

	/**
	 * Place some tiles horizontally or vertically on a sequence of unoccupied cells 
	 * in the game board.
	 * 
	 * The game engine will return the state of the game board after the tiles 
	 * have been placed on the board as a String object.
	 * 
	 * @param play	information about where to place which tile in the form of  
	 * STARTING_CELL; DIRECTION; LETTER_POSITIONS_IN_RACK, e.g. B3, DOWN, 513
	 * 
	 * @return the state of the game board after the tiles 
	 * have been placed on the board as a String object
	 */
	public String play(Play play) {
		StringBuilder builder = new StringBuilder();
		//gets starting cell for the play
		String startingCell=play.cell();
		char[] cellArray=startingCell.toCharArray();
		int backCell=cellArray[1];
		
		//converts the character in the cell to a integer
		String letters = "abcdefghij";
		char[] letterArray  = letters.toCharArray();		

		char frontCell = Character.toLowerCase(cellArray[0]);
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int frontChar=alphabet.indexOf(frontCell)+1;

		String lettersInRack=play.letterPositionsInRack();

		char[] lettersRackArray=lettersInRack.toCharArray();

		//loops through the chosen values to be put into the Board
		for(int i = 0; i <lettersInRack.length();i++) {
			
			//checks if the board space is empty
			if(gameBoard[frontChar][cellArray[backCell]]=='+' ||
					gameBoard[frontChar][cellArray[backCell]]=='-' ) {
				
				//gets the letter
				char letter=lettersRackArray[i];
				//puts it into the board
				gameBoard[frontChar][cellArray[backCell]]=letter;
				
				//if the direction is across, move to next position to the right
				if(play.dir().equals("ACROSS")) {
					backCell++;
				}
				//if not move one down
				else {
					frontChar++;
				}
			}

	
		}
		//return the update board
		String result = builder.toString();
			return result + '\n' + "tile rack: "+String.valueOf(gameBoard);
	}

	/**
	 * Calculate the points for the tiles placed on the game board in a intended play 
	 * (i.e. move).
	 * 
	 * @param play	information about where to place which tile in the form of  
	 * STARTING_CELL; DIRECTION; LETTER_POSITIONS_IN_RACK, e.g. B3, DOWN, 513
	 * 
	 * @return	a message showing the points to be scored as a String object
	 */
	public String calculateScore(Play play) {

		// Creating a Hash-map to store the letters and their values.
		HashMap<Character, Integer> pointLetter = new HashMap<Character, Integer>();
		//inputting all the letters into the hash-map with their values
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
		int total = 0;
		String startingCell=play.cell();


		char[] arrayForCell=startingCell.toCharArray();


		// going through the 5 letters on the rack
		for(int i = 0; i <letterPositionsInRack.length();i++) {

			int position = Character.getNumericValue(letterPositionsInRack.charAt(i));
			char letterInPosition=rack[position];

			if( ((arrayForCell[0]=='E' || arrayForCell[0]=='F') && (arrayForCell[1]=='2' || arrayForCell[1]=='9')) ||
					((arrayForCell[0]=='D' || arrayForCell[0]=='G') && (arrayForCell[1]=='4' || arrayForCell[1]=='7'))) {


				//double points
				total=total+(pointLetter.get(letterInPosition)*2);

			}
			else {
				total = total+pointLetter.get(letterInPosition);
			}
		}
		//String returning the points
		return ("The Word score is : " + total);
	}

	/**
	 * Check the validity of a specified play (i.e. move).
	 * Display a message stating "Valid" or "Invalid" after the check. 
	 * With a valid play, all new English words introduced to the game board 
	 * will be displayed. With an invalid play, the invalid letter sequence 
	 * introduced to the game board will also be returned.
	 * 
	 * @param play	information about where to place which tile in the form of  
	 * STARTING_CELL; DIRECTION; LETTER_POSITIONS_IN_RACK, e.g. B3, DOWN, 513
	 * 
	 * @return a message stating "Valid" or "Invalid". With a valid play, 
	 * the game engine will also display all new English words introduced to 
	 * the game board. With an invalid play, the game engine will also display 
	 * the invalid letter sequence introduced to the game board.
	 */
	public String checkValidity(Play play)
	{
		//a string to hold the word being verified
		String currentword=null;
		Boolean endofword = true;
		Boolean ValidMove = true;

		//go along the game-board array width
		for(int i = 0; i < gameBoard[0].length; i++)
		{
			//go down the game-board array
			for(int j = 0; j <gameBoard.length; j++)
			{
				//if there is a letter at this position add it to the word to be checked
				if((gameBoard[i][j] != ' ') && (gameBoard[i][j] != '+'))
				{
					currentword += gameBoard[i][j];
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
		for(int i = 0; i <= gameBoard.length; i++)
		{
			//go down the game-board array
			for(int j = 0; j <= gameBoard[0].length; j++)
			{
				//if there is a letter at this position add it to the word to be checked
				if((gameBoard[i][j] != ' ') && (gameBoard[i][j] != '+'))
				{
					currentword += gameBoard[i][j];
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

