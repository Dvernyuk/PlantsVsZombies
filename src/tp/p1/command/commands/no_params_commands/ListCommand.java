package tp.p1.command.commands.no_params_commands;

import tp.p1.command.commands.NoParamsCommand;
import tp.p1.factory.PlantFactory;
import tp.p1.logic.Game;

public class ListCommand extends NoParamsCommand {
	
	
	public ListCommand(){
		super("[L]ist","print the list of available plants.","list","l");
	}
	
	public boolean execute(Game game) {
		System.out.println('\n'+PlantFactory.listOfAvilablePlants());
		
		return false;
	}
}
