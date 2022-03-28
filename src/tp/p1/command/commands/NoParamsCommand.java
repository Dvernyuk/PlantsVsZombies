package tp.p1.command.commands;

import tp.p1.command.Command;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.logic.Game;

public abstract class NoParamsCommand extends Command {
	protected String command, commandLetter;
	
	public NoParamsCommand(String commandName, String helpInfo, String nCommand, String nCommandLetter) {
		super(commandName, "", helpInfo);
		command = nCommand;
		commandLetter = nCommandLetter;
	}
	
	public abstract boolean execute(Game game);
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command ret=null;
		
			if(commandWords[0].toLowerCase().equals(command) || commandWords[0].toLowerCase().equals(commandLetter)) {
				if(commandWords.length==1) {
					ret=this;
				} else {
					throw new CommandParseException(command.substring(0, 1).toUpperCase()+command.substring(1)+" command has no arguments");
				}
			}
			
		return ret;
	}
}
