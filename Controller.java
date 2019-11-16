/**
 * 
 */
package wordGame;

/**
 * A controller for the word game.
 * This controller includes the features that the intended
 * prototype system is expected to have.
 * 
 * @author Sylvia Wong
 * @version 31/10/2019
 */
public interface Controller {

	public controller(){
	
	//get the list of words from the file
	BufferedReader fileReader = new BufferedReader(new FileReader(wordlist.txt));
	//create a list to store the valid words in
	List<String> WordList = new ArrayList<String>();
	//add each line to the arraylist as a new word
	while((String line = fileReader.readLine()) != null) {
	    wordlist.add(line);
	}
	fileReader.close();

	}
	
	/**
	 * Refill the tile rack with randomly selected tiles.
	 * @return the state of the tile rack
	 */
	public String refillRack();
	
	/**
	 * Return the current state of the game board and the contents of the player's tile rack
	 * as a String object.
	 * @return the current state of the game board and the contents of the player's tile rack
	 * as a String object
	 */
	public String gameState();
	
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
	public String play(Play play);
	
	/**
	 * Calculate the points for the tiles placed on the game board in a intended play 
	 * (i.e. move).
	 * 
	 * @param play	information about where to place which tile in the form of  
	 * STARTING_CELL; DIRECTION; LETTER_POSITIONS_IN_RACK, e.g. B3, DOWN, 513
	 * 
	 * @return	a message showing the points to be scored as a String object
	 */
	public String calculateScore(Play play);
	
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
	public String checkValidity(Play play, char[,] board);
	{
		//a string to hold the word being verified
		string currentword;
		bool endofword = true;
		//go along the gameboard array width
		for(int i = 0; i <= board[].length[0]; i++)
		{
			//go down the gameboard array
			for(int j = 0; j <= board[].length; j++)
			{
				//if there is a letter at this position add it to the word to be checked
				if((board[i,j] != ' ') && (board[i,j] != '+'))
				{
					currentword += board[i,j];
					endofword = false
				}
				//when the word ends check the word in the dictionary
				else if (endofword = false)
				{
					endofword = true;
					
				}
				
				
			}
		}
	}
	
}
