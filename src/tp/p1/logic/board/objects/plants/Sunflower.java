package tp.p1.logic.board.objects.plants;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;

public class Sunflower extends Plant {
	private static int soles;
	private static Game game;
	
	public Sunflower(int iniX, int iniY, Game nGame) {
		super(iniX,iniY,20,1,0,2);
		
		soles = 10;
		
		game = nGame;
	}
	
	public Sunflower(int iniX, int iniY, int iniFr, int iniVida , Game nGame) {
		super(iniX,iniY,50,iniVida,10,2);	
		
		frActual = iniFr;
		
		game = nGame;
	}
	
	public Sunflower() {
		super(-1,-1,20,1,0,2);
	}
	
	public void update()
	{
		frActual -= 1;
		if(frActual==0) {
			frActual = fr;
			game.addSuns(soles);
		}

	}
	
	public String getInfo() {
		return "[S]unflower: Cost: "+coste+" suncoins Harm: "+dmg;
	}
	
	public String toStringDebug() {
		return "S[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + frActual + "]";
	}
	
	public Plant parse(String plantName,int factoryX, int factoryY, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("sunflower")||plantName.equals("s"))
			ret = new Sunflower(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Plant parseLoad(String plantName,int factoryX, int factoryY, int vidaFac, int frFac, Game factoryGame) {
		Plant ret = null;
		
		if(plantName.equals("sunflower")||plantName.equals("s"))
			ret = new Peashooter(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	public String toString() {
		return "S [" + vida + "]";
	}
	
	public String externalise() {
		return "S:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
}
