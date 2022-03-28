package tp.p1.logic.board.objects.zombies;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Zombie;

public class BucketheadZombie extends Zombie {
	private final int keyNumber = 1;
	
	public BucketheadZombie(int iniX, int iniY, Game nGame) {
		super(iniX, iniY, 8, 1, 4, 1, nGame);
	}
	
	public BucketheadZombie(int iniX, int iniY, int iniFrVel, int iniVida , Game nGame) {
		super(iniX, iniY, iniVida, 1, 4, 1, nGame);	
		
		frVelActual = iniFrVel;
	}
	
	public BucketheadZombie() {
		super(-1, -1, 8, 1, 4, 1, null);
	}
	
	public String toString() {
		return "W [" + vida + "]";
	}
	
	public String toStringDebug() {
		return "W[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + frVelActual + "]";
	}
	
	public Zombie parse(int keyN,int factoryX, int factoryY, Game factoryGame) {
		Zombie ret = null;
		
		if(keyNumber == keyN)
			ret = new BucketheadZombie(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Zombie parseLoad(int keyN,int factoryX, int factoryY,int frFac,int vidaFac, Game factoryGame) {
		Zombie ret = null;
		
		if(keyNumber == keyN)
			ret = new BucketheadZombie(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	
	public String getInfo() {
		return "[Z]ombie  caracubo: speed: "+frVel+" Harm: "+dmg+" Life: "+vida;
	}
	
	public String externalise() {
		return "W:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
	
	public int keyNumber(String letter) {
		int ret=-1;
		
		if(letter.equals("W"))
			ret=keyNumber;
		
		return ret;
	}
}
