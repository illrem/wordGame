package wordGame;

import java.io.IOException;

public class RunGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = null;
		try {
			game = new Game();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TUI tui = new TUI(game);
	}

}
