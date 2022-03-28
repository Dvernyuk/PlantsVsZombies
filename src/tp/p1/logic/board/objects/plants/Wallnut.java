package tp.p1.logic.board.objects.plants;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;

public class Wallnut extends Plant {
	
	public Wallnut(int iniX, int iniY, Game nGame) {
		super(iniX,iniY,50,10,0,0);
	}
	
	public Wallnut(int iniX, int iniY, int iniFr, int iniVida , Game nGame) {
		super(iniX,iniY,50,iniVida,10,2);	
		
		frActual = iniFr;
	}
	
	public Wallnut() {
		super(-1,-1,50,10,0,0);
	}
	
	public void update() {
		//Nothing to see here folks
	}
	
	public String getInfo() {
		return "[N]uez: Cost: "+coste+" suncoins Harm: "+dmg;
	}
	
	public String toStringDebug() {
		return "N[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + fr + "]";
	}
	
	public Plant parse(String plantName,int factoryX, int factoryY, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("nuez")||plantName.equals("n"))
			ret = new Wallnut(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Plant parseLoad(String plantName,int factoryX, int factoryY, int vidaFac, int frFac, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("nuez")||plantName.equals("n"))
			ret = new Peashooter(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	public String toString() {
		return "N [" + vida + "]";
	}
	
	public String externalise() {
		return "N:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
}
