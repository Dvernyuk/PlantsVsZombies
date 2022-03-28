package tp.p1.command.commands.no_params_commands;

import tp.p1.command.commands.NoParamsCommand;
import tp.p1.logic.Game;

public class ExitCommand extends NoParamsCommand {
	
	
	public ExitCommand(){
		super("[E]xit","terminate the program.","exit","e");
	}
	
	public boolean execute(Game game) {
		game.endIt();
		
		return false;
	}
}
