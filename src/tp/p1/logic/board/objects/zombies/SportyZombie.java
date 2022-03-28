package tp.p1.logic.board.objects.zombies;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Zombie;

public class SportyZombie extends Zombie {
	private final int keyNumber = 2;

	public SportyZombie(int iniX, int iniY, Game nGame) {
		super(iniX, iniY, 2, 1, 1, 1, nGame);
	}
	
	public SportyZombie(int iniX, int iniY, int iniFrVel, int iniVida , Game nGame) {
		super(iniX, iniY, iniVida, 1, 1, 1, nGame);	
		
		frVelActual = iniFrVel;
	}
	
	public SportyZombie() {
		super(-1, -1, 2, 1, 1, 1, null);
	}
	
	public String toString() {
		return "X [" + vida + "]";
	}
	
	public String toStringDebug() {
		return "X[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + frVelActual + "]";
	}
	
	public Zombie parse(int keyN,int factoryX, int factoryY, Game factoryGame) {
		Zombie ret = null;
		
		if(keyNumber == keyN)
			ret = new SportyZombie(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Zombie parseLoad(int keyN,int factoryX, int factoryY,int frFac,int vidaFac, Game factoryGame) {
		Zombie ret = null;
		
		if(keyNumber == keyN)
			ret = new BucketheadZombie(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	public String getInfo() {
		return "[Z]ombie deportista: speed: "+frVel+" Harm: "+dmg+" Life: "+vida;
	}
	
	public String externalise() {
		return "X:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
	
	public int keyNumber(String letter) {
		int ret=-1;
		
		if(letter.equals("X"))
			ret=keyNumber;
		
		return ret;
	}
}
