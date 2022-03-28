package tp.p1.command.commands;

import tp.p1.command.Command;
import java.io.*;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.command.commands.exceptions.FileContentsException;
import tp.p1.logic.Game;

public class SaveCommand extends Command {
	private String fileName;
	
	public SaveCommand(){
		super("[S]ave","<filename>"," Save the state of the game to a file.");
	}
	
	
	public boolean execute(Game game) throws FileContentsException {
		FileWriter fichero = null;
		
		try {
			fichero = new FileWriter(fileName);
			String cadena = game.externalise();
			
			fichero.write("Plants Vs Zombies v3.0"+cadena);
		
		
		} catch(IOException e) {
			throw new FileContentsException();
		} finally {
			try {
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		if(commandWords[0].toLowerCase().equals("s")||commandWords[0].toLowerCase().equals("save")) {
			if(commandWords.length==2) {
				fileName = commandWords[1];
				command = this;
			} else {
				throw new CommandParseException("Incorrect number of arguments for save command: [S]ave <filename>");
			}
		}
		
		return command;
	}
}
