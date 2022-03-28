package tp.p1.command.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp.p1.command.Command;
import tp.p1.command.commands.exceptions.CommandParseException;
import tp.p1.command.commands.exceptions.FileContentsException;
import tp.p1.factory.PlantFactory;
import tp.p1.factory.ZombieFactory;
import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;
import tp.p1.logic.board.objects.Zombie;

public class LoadCommand extends Command {
	private String fileName;
	
	public LoadCommand(){
		super("[Lo]ad","<filename>","Load the state of the game from a file.");
	}
	
	public boolean execute(Game game) throws FileContentsException {
		FileReader fichero = null;
		BufferedReader bw = null;
		String[] object, cad, grupo;
		String dif="";
		int cycle=0, suns=0, remZomb=0, keyN, nElem, i, j, numElemGru;
		Plant plant;
		Zombie zombie;
		
		try {
			fichero = new FileReader(fileName);
			bw = new BufferedReader(fichero);
			
			cad = bw.readLine().trim().split("\\s+");
			nElem = cad.length;
			i=0;

			while(i<nElem && !cad[i].equals("plantList:")) { //Añadiendo valores del game
				switch(cad[i]) {
				case "cycle:":
					cycle = Integer.parseInt(cad[i+1]);
				break;
				case "sunCoins:":
					suns = Integer.parseInt(cad[i+1]);
				break;
				case "level:":
					dif = cad[i+1];
				break;
				case "remZombies:":
					remZomb = Integer.parseInt(cad[i+1]);
				break;
				}
				i++;
			}
			
			game.loadGame(cycle, suns, dif, remZomb);
			//Añadiendo Plantas
			i++;
		
			if(i<nElem && !cad[i].equals("zombieList:")) {
				j=0;
				grupo = cad[i].trim().split(",");
				numElemGru = grupo.length;
				while(j<numElemGru) {
					object = grupo[j].trim().split(":");
					plant = PlantFactory.getPlantLoad(object[0].toLowerCase(), Integer.parseInt(object[2]), Integer.parseInt(object[3]), Integer.parseInt(object[1]), Integer.parseInt(object[4]), game);
					game.addPlant(plant);
					j++;
				}
				i++;
			}
			
			//Añadiendo zombies
			
			i++;

			if(i<nElem && cad[i-1].equals("zombieList:")) {
				j=0;
				grupo = cad[i].trim().split(",");
				numElemGru = grupo.length;
				while(j<numElemGru) {
					object = grupo[j].trim().split(":");
					keyN = ZombieFactory.keyNumber(object[0]);
					zombie = ZombieFactory.getZombieLoad(keyN, Integer.parseInt(object[2]), Integer.parseInt(object[3]), Integer.parseInt(object[4]), Integer.parseInt(object[1]), game);
					game.addZombie(zombie);
					j++;
				}
			}
			
		} catch(IOException e) {
			throw new FileContentsException();
		} finally {
			try {
				bw.close();
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		if(commandWords[0].toLowerCase().equals("lo")||commandWords[0].toLowerCase().equals("load")) {
			if(commandWords.length==2) {
				fileName = commandWords[1];
				command = this;
			} else {
				throw new CommandParseException("Incorrect number of arguments for load command: [Lo]ad <filename>");
			}
		}
		
		return command;
	}
}
