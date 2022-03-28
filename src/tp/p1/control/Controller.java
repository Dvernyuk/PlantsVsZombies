package tp.p1.control;

import java.util.Scanner;
import tp.p1.command.*;
import tp.p1.command.commands.exceptions.CommandExecuteException;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.command.commands.exceptions.FileContentsException;
import tp.p1.logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	
	public Controller(Game nGame) {
		in = new Scanner(System.in);
		
		game = nGame;
	}
	
	public void run() {
		game.printGame();
		
		while (!game.isFinished()) {
			System.out.print("Command > ");
			String[] words = in.nextLine().trim().split("\\s+");
			try {
				Command command = CommandParser.parseCommand(words);
				if (command != null) {
					if(command.execute(game) && !game.isFinished())
						game.printGame();
				}
				else {
					System.err.println("Unknown command. Use ’help’ to see the available commands");
				}
			} catch (FileContentsException | CommandParseException | CommandExecuteException ex) {
				System.out.format(ex.getMessage() + " %n %n");
			}
		}
	}
	 
	/*public void setNoPrintGameState() {
		noPrint = true;
	}
	
	public void exit() {
		exit=true;
	}*/
}
