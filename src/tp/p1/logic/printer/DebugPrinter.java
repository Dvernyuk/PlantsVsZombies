package tp.p1.logic.printer;

import tp.p1.logic.Game;

public class DebugPrinter extends BoardPrinter {
	private int plants, zombies;
	
	public DebugPrinter(Game game) {
		super(game, game.xVal()*game.yVal(), 1);
	}
	
	public void encodeGame(Game game) {
		int plants, zombies;
		
		plants = game.nPlants();
		zombies = game.nZombies();
		dimY = plants + zombies;
		
		board = new String [dimX][dimY];
		
		for(int i=0;i<plants;i++) {
			board[0][i] = game.toStringDebugPlants(i);
		}
		
		for(int i=0;i<zombies;i++) {
			board[0][i+plants] = game.toStringDebugZombies(i);
		}
	}
	
	public int nObjects(Game game) {
		plants = game.nPlants();
		zombies = game.nZombies();
		return plants + zombies;
	}
	
	public void printGame(Game game) {
		encodeGame(game);
		System.out.println(boardToString(19));
		game.info();
		game.extraInfo();
	}
}
