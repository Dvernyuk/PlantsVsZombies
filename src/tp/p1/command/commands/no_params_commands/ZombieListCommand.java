package tp.p1.command.commands.no_params_commands;

import tp.p1.command.commands.NoParamsCommand;
import tp.p1.factory.ZombieFactory;
import tp.p1.logic.Game;

public class ZombieListCommand extends NoParamsCommand {

	
	public ZombieListCommand(){
		super("zombieList","print the list of zombies.","zombielist",null);
	}
	
	public boolean execute(Game game) {
		System.out.println('\n'+ZombieFactory.listOfZombies());
		
		return false;
	}
}
