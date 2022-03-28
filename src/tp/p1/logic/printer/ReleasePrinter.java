package tp.p1.logic.printer;

import tp.p1.logic.Game;

public class ReleasePrinter extends BoardPrinter {
	
	public ReleasePrinter(Game game, int newDimX, int newDimY) {
		super(game, newDimX, newDimY);
	}
	
	public void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {
					board[i][j] = game.toString(j, i);	
			}
		}
	}
	
	public void printGame(Game game) {
		encodeGame(game);
		System.out.println(boardToString(7));
		game.info();
	}
}
