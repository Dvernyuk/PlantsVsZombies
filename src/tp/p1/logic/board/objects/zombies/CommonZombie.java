package tp.p1.logic.board.objects.zombies;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Zombie;

public class CommonZombie extends Zombie {
	private final int keyNumber = 0;

	public CommonZombie(int iniX, int iniY, Game nGame) {
		super(iniX, iniY, 5, 1, 2, 1, nGame);
	}
	
	public CommonZombie(int iniX, int iniY, int iniFrVel, int iniVida , Game nGame) {
		super(iniX, iniY, iniVida, 1, 2, 1, nGame);	
		
		frVelActual = iniFrVel;
	}
	
	public CommonZombie() {
		super(-1, -1, 5, 1, 2, 1, null);
	}
	
	public String toString() {
		return "Z [" + vida + "]";
	}
	
	public String toStringDebug() {
		return "Z[l:" + vida + ",x:" + x + ",y:" + y + ",t:" + frVelActual + "]";
	}
	
	public Zombie parse(int keyN,int factoryX, int factoryY, Game factoryGame) {
		Zombie ret = null;
		
		if(keyNumber == keyN)
			ret = new CommonZombie(factoryX, factoryY, factoryGame);
		
		return ret;
	}
	
	public Zombie parseLoad(int keyN,int factoryX, int factoryY,int frFac,int vidaFac, Game factoryGame) {
		Zombie ret = null;
		
		if(keyNumber == keyN)
			ret = new BucketheadZombie(factoryX, factoryY,frFac,vidaFac, factoryGame);
		
		return ret;
	}
	
	public String getInfo() {
		return "[Z]ombie comun: speed: "+frVel+" Harm: "+dmg+" Life: "+vida;
	}
	
	public String externalise() {
		return "Z:" + vida + ":" + x + ":" + y + ":" + frActual;
	}
	
	public int keyNumber(String letter) {
		int ret=-1;
		
		if(letter.equals("Z"))
			ret=keyNumber;
		
		return ret;
	}
}
