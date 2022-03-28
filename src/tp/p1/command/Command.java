package tp.p1.command;

import tp.p1.command.commands.exceptions.CommandExecuteException;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.command.commands.exceptions.FileContentsException;
import tp.p1.logic.Game;

abstract public class Command {
	private String helpText;
	private String helpInfo;
	protected final String commandName;

	public Command(String commandText, String commandTextMsg, String helpTextMsg) {
		commandName = commandText;
		helpText = commandTextMsg;
		helpInfo = helpTextMsg;
		}
	
	public abstract boolean execute(Game game) throws CommandExecuteException, FileContentsException;
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	public String helpText(){return commandName + helpText + ": " + helpInfo;}
}
