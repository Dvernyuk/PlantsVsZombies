package tp.p1.logic.board.objects;

import tp.p1.logic.Game;

abstract public class Zombie extends GameObject{
	protected int frActual, frVelActual, fr, dmg, frVel;
	private static Game game;
	
	public Zombie(int iniX, int iniY, int nVida, int nFr, int nFrVel, int nDmg, Game nGame) {
		super(iniX, iniY, nVida);
		
		fr = nFr;
		frActual = fr;
		frVel =  nFrVel;
		frVelActual = frVel;
		dmg = nDmg;
		
		game = nGame;
	}
	
	public abstract String toString();
	public abstract String toStringDebug();
	public abstract String externalise();
	public abstract int keyNumber(String letter);
	public abstract String getInfo();
	public abstract Zombie parse(int keyN,int factoryX, int factoryY, Game factoryGame);
	public abstract Zombie parseLoad(int keyN,int factoryX, int factoryY,int frFac,int vidaFac, Game factoryGame);

	public void update() {
		if(game.findPlant(x-1, y)!=-1) {
			frActual-=1;
			if(frActual==0) {
				frActual = fr;
				game.harmPlant(x-1, y, dmg);
			}
		} else {
			if(game.findZombie(x-1, y)==-1) {
				frVelActual-=1;
				if(frVelActual==0) {
					frVelActual = frVel;
					x-=1;
					if(x==-1) { //Si ganan los zombies
						game.zombiesWin();
					}
				}
			}
		}
	}

}