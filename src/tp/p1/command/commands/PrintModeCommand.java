package tp.p1.command.commands;

import tp.p1.command.Command;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.logic.Game;
import tp.p1.logic.printer.DebugPrinter;
import tp.p1.logic.printer.GamePrinter;
import tp.p1.logic.printer.ReleasePrinter;

public class PrintModeCommand extends Command {
	private String mode;
	
	public PrintModeCommand() {
		super("[P]rintMode"," <mode>","Change print mode [Release|Debug].");
	}
	
	public boolean execute(Game game) {
		boolean ret = false;
		
		if(mode.equals("debug")) {
			GamePrinter printer = new DebugPrinter(game);
			game.printType(printer);
			ret = true;
		} else if(mode.equals("release")) {
			GamePrinter printer = new ReleasePrinter(game,game.xVal(),game.yVal());
			game.printType(printer);
			ret = true;
		}
		
		return ret;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
			if(commandWords[0].toLowerCase().equals("p")||commandWords[0].toLowerCase().equals("printmode"))
				if(commandWords.length==2) {
					mode = commandWords[1].toLowerCase();
					if(commandWords[1].toLowerCase().equals("release")||commandWords[1].toLowerCase().equals("debug")) {
						command = this;
					} else {
						throw new CommandParseException("Unknown print mode: "+mode);
					}
				} else {
					throw new CommandParseException("Incorrect number of arguments for printmode command: [P]rintMode <mode>");
				}
		
		return command;
	}
}
