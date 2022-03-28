package tp.p1.command;

import tp.p1.command.commands.*;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.command.commands.no_params_commands.*;

public class CommandParser {
		private static Command[] availableCommands = {
				new AddCommand(),
				new HelpCommand(),
				new ResetCommand(),
				new ExitCommand(),
				new ListCommand(),
				new NoneCommand(),
				new PrintModeCommand(),
				new SaveCommand(),
				new LoadCommand(),
				new ZombieListCommand(),
			};

	
	public static Command parseCommand(String[] string) throws CommandParseException {
		Command command = null;
		int i=0;
		
		while(command==null && i<availableCommands.length) {
			try {
				command=availableCommands[i].parse(string);
			} catch(CommandParseException e) {
				throw e;
			}
			i++;
		}
		
		return command;
	}
	
	public static String commandHelp() {
		String helpText="";
		
		for(int i=0;i<availableCommands.length;i++)
			helpText += (availableCommands[i].helpText()+'\n');
		
		return helpText;
	}
}
