package tp.p1.logic.board;

import tp.p1.logic.board.objects.GameObject;

public class Board {
	private GameObjectList plants, zombies;
	
	public Board(int x, int y) {
		plants = new GameObjectList(x,y);
		zombies = new GameObjectList(x,y);
	}
	
	public void update() {
		plants.update();
		zombies.update();
	}
	
	public boolean addPlant(GameObject object) {
		return plants.addObject(object);
	}
	
	public boolean addZombie(GameObject object) {
		return zombies.addObject(object);
	}
	
	public boolean harmPlant(int posX, int posY, int dmg) {
		return plants.harm(posX, posY, dmg);
	}
	
	public boolean harmZombie(int posX, int posY, int dmg) {
		return zombies.harm(posX, posY, dmg);
	}
	
	public int findPlant(int posX, int posY) {
		return plants.find(posX, posY);
	}
	
	public int findZombie(int posX, int posY) {
		return zombies.find(posX, posY);
	}
	
	public String toStringPlant(int pos) {
		return plants.toString(pos);
	}
	
	public String toStringZombie(int pos) {
		return zombies.toString(pos);
	}
	
	public int nZombies() {
		return zombies.nObjects();
	}
	
	public int nPlants() {
		return plants.nObjects();
	}
	
	public String toStringDebugPlants(int n) {
		return plants.toStringDebug(n);
	}
	
	public String toStringDebugZombies(int n) {
		return zombies.toStringDebug(n);
	}
	
	public String externalise() {
		String ret;
		
		ret = "plantList: ";
		ret += plants.externalise();
		ret += " zombieList: ";
		ret += zombies.externalise();
		
		return ret;
	}
	
	public void setToZero() {
		plants.setToZero();
		zombies.setToZero();
	}
}
