package tp.p1;

import tp.p1.control.Controller;
import tp.p1.logic.Game;
import tp.p1.logic.Level;
import java.util.Random;

public class PlantsVsZombies {
	
	public static void main(String[] args) {
		Level level;
		int seed = 0;
		
		if(args.length>2 || args.length<1) {
			throw new RuntimeException("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]");
		} else {
			level = Level.nLevel(args[0]);
			
			if(level==null) {
				throw new RuntimeException("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
			}
			else {
				if(args.length==2) {
					try {
						seed = Integer.parseInt(args[1]);
					} catch(Exception e) {
						throw new RuntimeException("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]: the seed must be a number");
					}
				}
				else if(args.length==1) {
					seed = new Random().nextInt(10000);
				}
				
				Game game = new Game(level, seed, 8, 4);
				Controller controller = new Controller(game);
				
				controller.run();
			}
		}
	}
}