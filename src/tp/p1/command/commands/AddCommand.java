package tp.p1.command.commands;

import tp.p1.command.Command;
import tp.p1.command.commands.exceptions.CommandExecuteException;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.factory.PlantFactory;
import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;

public class AddCommand extends Command {
	private int  x, y;
	private String plantName;
	
	public AddCommand(){
		super("[A]dd"," <plant> <x> <y>", "adds a plant in position x, y.");
	}
	
	public boolean execute(Game game) throws CommandExecuteException {
		boolean ret = false;
		Plant plant=null;
		
		if(x>=game.xVal()-1 || x<0 || y>=game.yVal() || y<0) {	//Si no se pone bine las coordenadas
			throw new CommandExecuteException("Failed to add "+plantName+": ("+x+", "+y+") is an invalid position");
			
		} else {
			if(game.isThereSomething(x, y)) {	//Si hay algo en su posicion
				throw new CommandExecuteException("Failed to add "+plantName+": ("+x+", "+y+") is an invalid position");
			
			} else {
				plant = PlantFactory.getPlant(plantName, x, y, game);
				
				if(plant==null) {	//Si no existe dicha planta
					throw new CommandExecuteException("Unknown plant name: "+plantName);
				
				} else {
					if(!game.restarSuns(plant.cost())) {	//Si no hay suficientes suns
						throw new CommandExecuteException("Failed to add "+plantName+": not enough suncoins available");
					
					} else {
						game.addPlant(plant);
						ret = true;
					}
				}
			}
		}

		return ret;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		if(commandWords[0].toLowerCase().equals("a")||commandWords[0].toLowerCase().equals("add")) {
			if(commandWords.length==4) {
				try {	
					plantName = commandWords[1].toLowerCase();
					x = Integer.parseInt(commandWords[2]);
					y = Integer.parseInt(commandWords[3]);
					command = this;
				} catch(Exception e) {
					throw new CommandParseException("Invalid argument for add command, number expected: [A]dd <plant> <x> <y>");
				}
			} else {
				throw new CommandParseException("Incorrect number of arguments for add command: [A]dd <plant> <x> <y>");
			}
		}

		return command;
	}
}
