package tp.p1.factory;

import tp.p1.logic.Game;
import tp.p1.logic.board.objects.Plant;
import tp.p1.logic.board.objects.plants.*;

public class PlantFactory {
		private static Plant[] availablePlants = {
				new Sunflower(),
				new Peashooter(),
				new Cherrybomb(),
				new Wallnut()
		};
		
		public static Plant getPlant(String plantName, int x , int y, Game game){
			Plant plant = null;
			int i=0;
			
			while(plant==null && i<availablePlants.length) {
				plant = availablePlants[i].parse(plantName,x,y,game);
				i++;
			}
			
			return plant;
		}
		
		public static Plant getPlantLoad(String plantName, int x , int y, int vida, int fr, Game game){
			Plant plant = null;
			int i=0;
			
			while(plant==null && i<availablePlants.length) {
				plant = availablePlants[i].parseLoad(plantName,x,y,vida,fr,game);
				i++;
			}
			
			return plant;
		}
		
		public static String listOfAvilablePlants() {
			String helpText="";
			
			for(int i=0;i<availablePlants.length;i++)
				helpText += (availablePlants[i].getInfo()+'\n');
			
			return helpText;
		}
}
