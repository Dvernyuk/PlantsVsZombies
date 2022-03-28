package tp.p1.command.commands.no_params_commands;

import tp.p1.command.CommandParser;
import tp.p1.command.commands.NoParamsCommand;
import tp.p1.logic.Game;

public class HelpCommand extends NoParamsCommand {
	
	
	public HelpCommand(){
		super("[H]elp","print this help message.","help","h");
	}
	
	public boolean execute(Game game) {
		System.out.println('\n'+CommandParser.commandHelp());
		
		return false;
	}
}
