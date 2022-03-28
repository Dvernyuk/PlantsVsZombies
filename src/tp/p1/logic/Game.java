package tp.p1.logic;

import tp.p1.logic.board.Board;
import tp.p1.logic.board.objects.Plant;
import tp.p1.logic.board.objects.Zombie;
import tp.p1.logic.managers.*;
import tp.p1.logic.printer.GamePrinter;
import tp.p1.logic.printer.ReleasePrinter;

public class Game {
	private int cycleCount, x, y, seed;
	private boolean end;
	private SuncoinManager sMan;
	private ZombieManager zMan;
	private Board board;
	private Level level;
	private GamePrinter gp;
	
	public Game(Level nLevel, int nSeed, int nX, int nY) {
		cycleCount = 0;
		end = false;
		level = nLevel;
		seed = nSeed;
		x = nX;
		y = nY;
		
		gp = new ReleasePrinter(this,this.xVal(),this.yVal());
		sMan = new SuncoinManager();
		zMan = new ZombieManager(level.nZombies(), level.nFr(), seed, this);
		board = new Board(xVal(),yVal());
	}
	
	public void reset() {
		cycleCount = 0;
		
		sMan = new SuncoinManager();
		zMan = new ZombieManager(level.nZombies(),level.nFr(), seed, this);
		board = new Board(xVal(),yVal());
	}
	
	public void update() {
		board.update();
		zMan.isZombieAdded();
		playerWin();
		cycleCount++;
	}
	
	public void printGame() {
		gp.printGame(this);
	}
	
	public void printType(GamePrinter print) {
		gp = print;
	}
	
	public void info() {
		System.out.println("Number of cycles: " + cycleCount);
		System.out.println("Sun coins: " + sMan.nSuncoins());
		System.out.println("Remaining zombies: " + zMan.zombiesLeft());
	}
	
	public void extraInfo() {
		System.out.println("Level: " + level.toString());
		System.out.println("Seed: " + seed);
	}
	
	public String toString(int posX, int posY) {
		int pos;
		String ret;
		
		pos = findPlant(posX, posY);
		if(pos!=-1) {							//Si es una planta
			ret = board.toStringPlant(pos);
		} else {
			pos = findZombie(posX, posY);
			if(pos!=-1) {						//Si es un zombie
				ret = board.toStringZombie(pos);
			} else {							//Si no hay nada
				ret = " ";
			}
		}
		
		return ret;
	}
	
	public int nPlants() {
		return board.nPlants();
	}
	
	public int nZombies() {
		return board.nZombies();
	}
	
	public String toStringDebugPlants(int n) {
		return board.toStringDebugPlants(n);
	}
	
	public String toStringDebugZombies(int n) {
		return board.toStringDebugZombies(n);
	}
	
	public boolean addPlant(Plant plant) {
		return board.addPlant(plant);
	}
	
	public boolean addZombie(Zombie zombie) {
		return board.addZombie(zombie);
	}
	
	public int findPlant(int posX, int posY) {
		return board.findPlant(posX, posY);
	}
	
	public int findZombie(int posX, int posY) {
		return board.findZombie(posX, posY);
	}
	
	public boolean isThereSomething(int posX, int posY) {
		boolean ret = false;
		
		if(findPlant(posX, posY)!=-1 || findZombie(posX, posY)!=-1)
			ret=true;
		
		return ret;
	}
	
	public void lanzarGuisante(int posX, int posY, int dmg) {
		int i;
		boolean fin=false;
		
		i = posX;
		
		while(i<x && !fin) {
			fin = harmZombie( i, posY, dmg);
			i++;
		}
	}
	
	public void explotar(int posX, int posY, int dmg) { //No explota en el centro
		for(int i=(posX-1);i<=(posX+1);i++)
			for(int j=(posY-1);j<=(posY+1);j++) {
				if(i>=0 && i<x && j>=0 && j<y)
					if(i!=posX || j!=posY)
						harmZombie(i, j, dmg);
			}
	}
	
	public boolean harmPlant(int posX, int posY, int dmg) {
		return board.harmPlant(posX, posY, dmg);
	}
	
	public boolean harmZombie(int posX, int posY, int dmg) {
		return board.harmZombie(posX, posY, dmg);
	}
	
	public void addSuns(int suns) {
		sMan.add(suns);
	}
	
	public boolean restarSuns(int coste) {
		return sMan.restar(coste);
	}
	
	public int nSunCoins() {
		return sMan.nSuncoins();
	}
	
	public void zombiesWin() {
		System.out.println("Game over");
		System.out.println("Zombies win!");
		endIt();
	}
	
	public void playerWin() {
		if(zMan.zombiesLeft()<=0 && board.nZombies()<=0) {
			System.out.println("Game over");
			System.out.println("Player wins!");
			endIt();
		}
	}
	
	public String externalise() {
		String ret;
		
		ret=" cycle: "+cycleCount+" sunCoins: "+sMan.nSuncoins()
				+" level: "+level.toString()+" remZombies: "+zMan.zombiesLeft()+" ";
		ret += board.externalise();
		
		
		return ret;
	}
	
	public void loadGame(int nCycles, int nSuns, String nLevel , int zombiesLeft) {
		board.setToZero();
		cycleCount = nCycles;
		level = Level.nLevel(nLevel);
		zMan = new ZombieManager(zombiesLeft, level.nFr(), seed, this);
		sMan = new SuncoinManager(nSuns);
	}
	
	public void endIt() {
		end=true;
	}
	
	public boolean isFinished() {
		return end;
	}
	
	public int xVal() {
		return x;
	}
	
	public int yVal() {
		return y;
	}
	
	public int cycles() {
		return cycleCount;
	}
}