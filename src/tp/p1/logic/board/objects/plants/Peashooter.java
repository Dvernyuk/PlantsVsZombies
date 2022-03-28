package tp.p1.logic.board.objects.plants;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;

public class Peashooter extends Plant {
	private Game game;
	
	public Peashooter(int iniX, int iniY, Game nGame) {
		super(iniX,iniY,50,3,1,1);	
		
		game = nGame;
	}
	
	public Peashooter(int iniX, int iniY, int iniFr, int iniVida , Game nGame) {
		super(iniX,iniY,50,iniVida,10,2);	
		
		frActual = iniFr;
		
		game = nGame;
	}
	
	public Peashooter() {
		super(-1,-1,50,3,1,1);
	}
	
	public void update() {
		frActual-=1;
		if(frActual<=0) {
			frActual = fr;
			game.lanzarGuisante((x+1), y, dmg);
		}
	}
	
	public String getInfo() {
		return "[P]eashooter: Cost: "+coste+" suncoins Harm: "+dmg;
	}
	
	public String toStringDebug() {
		return "P[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + frActual + "]";
	}
	
	public Plant parse(String plantName,int factoryX, int factoryY, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("peashooter")||plantName.equals("p"))
			ret = new Peashooter(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Plant parseLoad(String plantName,int factoryX, int factoryY, int vidaFac, int frFac, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("peashooter")||plantName.equals("p"))
			ret = new Peashooter(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	public String toString() {
		return "P [" + vida + "]";
	}
	
	public String externalise() {
		return "P:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
}