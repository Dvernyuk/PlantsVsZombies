package tp.p1.logic.managers;

import java.util.Random;

import tp.p1.factory.ZombieFactory;
import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Zombie;

public class ZombieManager {
	private int zombiesLeft;
	private double fr;
	private Random generator;
	private Game game;
	
	public ZombieManager(int nZombies, double nFr, int nSeed, Game nGame) {
		zombiesLeft = nZombies;
		fr = nFr;
		generator = new Random(nSeed);
		
		game = nGame;
	}
	
	public boolean isZombieAdded() {
		boolean ret = false;
		double randDouble;
		int randInt, keyNumber;
		Zombie zombie=null;
		
		randDouble = generator.nextDouble();
		if(fr>=randDouble && zombiesLeft>0) {	//Hay zombie esta ronda?
			zombiesLeft-=1;
			
			randInt = generator.nextInt(game.yVal());	//Calle del zombie

			if(game.findZombie(game.xVal()-1, randInt)==-1) {	//Hay sitio para el zombie?
				keyNumber = generator.nextInt(ZombieFactory.zombiesLength());
				zombie = ZombieFactory.getZombie(keyNumber, game.xVal()-1, randInt, game);
				ret = game.addZombie(zombie);	//Adicion del zombie
			}
		}
		
		return ret;
	}
	
	public int zombiesLeft() {	
		return zombiesLeft;
	}
}
