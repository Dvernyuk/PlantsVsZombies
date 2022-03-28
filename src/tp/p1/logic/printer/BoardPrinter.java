package tp.p1.logic.printer;

import tp.p1.logic.Game;
import tp.p1.logic.util.MyStringUtils;

abstract public class BoardPrinter implements GamePrinter {
	protected final int dimX; 
	protected int dimY;
	protected String[][] board;
	protected static final String space = " ";
	
	
	public BoardPrinter(Game game, int dimX, int dimY) {
		this.dimX = dimY;
		this.dimY = dimX;
	}
	
	public abstract void encodeGame(Game game);
	
	public String boardToString(int cellSize) {
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}
}
