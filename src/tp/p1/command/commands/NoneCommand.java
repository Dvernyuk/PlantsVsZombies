package tp.p1.command.commands;

import tp.p1.command.Command;
import tp.p1.logic.Game;

public class NoneCommand extends Command {
	
	
	public NoneCommand(){
		super("none","","skips cycle.");
	}
	
	public boolean execute(Game game) {
		game.update();
		
		return true;
	}
	
	public Command parse(String[] commandWords) {
		Command command = null;

		if(commandWords.length==1 && commandWords[0].equals("")) {
			command = this;
		}
		
		return command;
	}
}
