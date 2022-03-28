package tp.p1.logic.board;

import tp.p1.logic.board.objects.GameObject;

public class GameObjectList {
	private GameObject objects[];
	private int nObjects, x, y;
	
	public GameObjectList(int nX, int nY) {
		x = nX;
		y = nY;
		objects = new GameObject[x*y];
		nObjects = 0;
	}
	
	public boolean addObject(GameObject object) {
		boolean ret=true;
		
		if(nObjects<x*y) {
			objects[nObjects] = object;
			nObjects++;
		} else {
			ret = false;
		}
		
		return ret;
	}
	
	public void update() {
		for(int i=0;i<nObjects;i++)
			objects[i].update();
	}
	
	public void delete(int pos) {
		nObjects-=1;
		for(int i=pos;i<nObjects;i++) {
			objects[i] = objects[i+1];
		}
	}
	
	public boolean harm(int posX, int posY, int dmg) {
		boolean ret=false;
		int i=0;
		
		while(i<nObjects && !ret) {
			if(objects[i].posX()==posX && objects[i].posY()==posY) {
				if(objects[i].harm(dmg)<=0)
					delete(i);
				ret=true;
			}
			i++;
		}
		
		return ret;
	}
	
	public int find(int posX, int posY) {
		int ret=-1;
		int i=0;
		
		while(i<nObjects && ret==-1) {
			if(objects[i].posX()==posX && objects[i].posY()==posY) {
				ret=i;
			}
			i++;
		}
		
		return ret;
	}
	
	public int nObjects() {
		return nObjects;
	}
	
	public String toString(int pos) {
		return objects[pos].toString();
	}
	
	public String toStringDebug(int n) {
		return objects[n].toStringDebug();
	}
	
	public String externalise() {
		String ret="";
		
		for(int i=0;i<nObjects;i++) {
			if(i==nObjects-1) {
				ret += objects[i].externalise();
			} else {
				ret += objects[i].externalise() + ",";
			}
		}
		
		return ret;
	}
	
	public void setToZero() {
		nObjects=0;
	}
}
