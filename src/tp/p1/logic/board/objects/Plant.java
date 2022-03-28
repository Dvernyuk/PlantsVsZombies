package tp.p1.logic.board.objects;

import tp.p1.logic.Game;

abstract public class Plant extends GameObject{
	protected int coste, dmg, fr, frActual;
	
	public Plant(int iniX, int iniY, int nCost, int nVida, int nDmg, int nFr) {
		super(iniX, iniY, nVida);
		coste = nCost;
		dmg=nDmg;
		fr = nFr;
		frActual = nFr;
	}
	
	public abstract String toString();
	public abstract String toStringDebug();
	public abstract String externalise();
	public abstract String getInfo();
	public abstract Plant parse(String plantName,int factoryX, int factoryY, Game factoryGame);
	public abstract Plant parseLoad(String plantName,int factoryX, int factoryY, int vidaFac, int frFac, Game factoryGame);
	public abstract void update();
	
	
	public int cost() {
		return coste;
	}
}
