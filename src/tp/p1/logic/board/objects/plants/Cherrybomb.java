package tp.p1.logic.board.objects.plants;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;

public class Cherrybomb extends Plant {
	private Game game;
	
	public Cherrybomb(int iniX, int iniY, Game nGame) {
		super(iniX,iniY,50,2,10,2);	
		
		game = nGame;
	}
	
	public Cherrybomb(int iniX, int iniY, int iniFr, int iniVida , Game nGame) {
		super(iniX,iniY,50,iniVida,10,2);	
		
		frActual = iniFr;
		
		game = nGame;
	}
	
	public Cherrybomb() {
		super(-1,-1,50,2,10,2);
	}
	
	public void update() {
		frActual-=1;
		if(frActual==0) {
			frActual = fr;
			game.explotar(x,y,dmg);
			game.harmPlant(x,y,vida);
		}
	}
	public String getInfo() {
		return "Peta[c]ereza: Cost: "+coste+" suncoins Harm: "+dmg;
	}
	
	public Plant parse(String plantName,int factoryX, int factoryY, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("petacereza")||plantName.equals("c"))
			ret = new Cherrybomb(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Plant parseLoad(String plantName,int factoryX, int factoryY, int vidaFac, int frFac, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("petacereza")||plantName.equals("c"))
			ret = new Peashooter(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	public String toString() {
		return "C [" + vida + "]";
	}
	
	public String toStringDebug() {
		return "C[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + frActual + "]";
	}
	
	public String externalise() {
		return "C:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
}
