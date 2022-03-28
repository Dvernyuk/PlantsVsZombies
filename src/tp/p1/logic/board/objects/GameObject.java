package tp.p1.logic.board.objects;

abstract public class GameObject {
	protected int x, y, vida;
	
	public GameObject(int iniX, int iniY, int nVida){
		x = iniX;
		y = iniY;
		vida = nVida;
	}
	
	public abstract void update();
	public abstract String toString();
	public abstract String toStringDebug();
	public abstract String getInfo();
	public abstract String externalise();
	
	public int harm(int d) {
		vida -= d;
		
		return vida;
	}
	
	public int posX() {
		return x;
	}
	
	public int posY() {
		return y;
	}
}
