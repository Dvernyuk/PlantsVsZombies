package tp.p1.factory;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Zombie;
import tp.p1.logic.board.objects.zombies.*;


public class ZombieFactory {
	private static Zombie[] availableZombies = {
			new CommonZombie(),
			new BucketheadZombie(),
			new SportyZombie()
	};
	
	public static Zombie getZombie(int keyNumber, int x , int y, Game game){
		Zombie zombie = null;
		int i=0;

		while(zombie==null && i<availableZombies.length) {
			zombie = availableZombies[i].parse(keyNumber,x,y,game);
			i++;
		}
		
		return zombie;
	}
	
	public static Zombie getZombieLoad(int keyNumber, int x , int y,int fr, int vida, Game game){
		Zombie zombie = null;
		int i=0;

		while(zombie==null && i<availableZombies.length) {
			zombie = availableZombies[i].parseLoad(keyNumber,x,y,fr,vida,game);
			i++;
		}
		
		return zombie;
	}
	
	public static int zombiesLength() {
		return availableZombies.length;
	}
	
	public static int keyNumber(String letter) {
		int ret=-1, i=0;
		
		while(ret==-1 && i<availableZombies.length) {
			ret = availableZombies[i].keyNumber(letter);
			i++;
		}
		
		return ret;
	}
	
	public static String listOfZombies() {
		String helpText="";
		
		for(int i=0;i<availableZombies.length;i++)
			helpText += (availableZombies[i].getInfo()+'\n');
		
		return helpText;
	}
}
