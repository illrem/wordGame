
public class Game implements Controller{
	
	public Game(){
		
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
	
	
	public String checkValidity(Play play, char[][] board);
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
					if (!wordlist.contains(currentword))
					{
						System.Out.Print("the word: " + currentword + " is invalid");
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
					if (!wordlist.contains(currentword))
					{
						System.Out.Print("the word: " + currentword + " is invalid");
						ValidMove = false;
					}
				}				
			}
		}
	}

}
