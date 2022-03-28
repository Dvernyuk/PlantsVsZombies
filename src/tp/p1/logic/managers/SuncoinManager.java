package tp.p1.logic.managers;

public class SuncoinManager {
	private int suncoins;
	
	public SuncoinManager() {
		suncoins = 50;
	}
	
	public SuncoinManager(int nSuns) {
		suncoins = nSuns;
	}
	
	public void add(int suns) {
		suncoins += suns;
	}
	
	public boolean restar(int suns) {
		boolean ret;
		
		if((suncoins-suns)<0)
			ret = false;
		else {
			suncoins-=suns;
			ret = true;
		}
		
		return ret;
	}
	
	public int nSuncoins() {
		return suncoins;
	}
}
