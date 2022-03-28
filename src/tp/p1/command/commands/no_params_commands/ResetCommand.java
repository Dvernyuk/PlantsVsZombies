package tp.p1.command.commands.no_params_commands;

import tp.p1.command.commands.NoParamsCommand;
import tp.p1.logic.Game;

public class ResetCommand extends NoParamsCommand {
	
	
	public ResetCommand(){
		super("[R]eset","resets game.","reset","r");
	}
	
	public boolean execute(Game game) {
		game.reset();
		
		return true;
	}
}
