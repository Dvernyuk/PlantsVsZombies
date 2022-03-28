package tp.p1.logic;

public enum Level {
	EASY, HARD, INSANE;
	
	public static Level nLevel(String dif) {
		Level ret = null;
		
		switch(dif) {
		case "EASY":
			ret = Level.EASY;
			break;
		case "HARD":
			ret = Level.HARD;
			break;
		case "INSANE":
			ret = Level.INSANE;
			break;
		}
		
		return ret;
	}
	
	public double nFr() {
		double fr;
		
		switch(this) {
		default:
		case EASY:
			fr = 0.1;
			break;
		case HARD:
			fr = 0.2;
			break;
		case INSANE:
			fr = 0.3;
			break;
		}
		
		return fr;
	}
	
	public int nZombies() {
		int num;
		
		switch(this) {
		default:
		case EASY:
			num = 3;
			break;
		case HARD:
			num = 5;
			break;
		case INSANE:
			num = 10;
			break;
		}
		
		return num;
	}
	
	public String toString() {
		String ret=null;
		
		switch(this) {
		default:
		case EASY:
			ret = "EASY";
			break;
		case HARD:
			ret = "HARD";
			break;
		case INSANE:
			ret = "INSANE";
			break;
		}
		
		return ret;
	}
}
