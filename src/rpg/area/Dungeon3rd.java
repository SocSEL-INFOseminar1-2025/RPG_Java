package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Fatalis;

public class Dungeon3rd extends Dungeon{
	public Dungeon3rd() {
		super.encountCounter = 0;
		super.floorNum = 3;
		super.setName("深層");
	}
	
	protected Monster nextBoss() {
		return new Fatalis();  //BigMatangoって仕様書には書いてるけど，多分Dragonよな？
	}
	
	protected Area nextArea() {
		return new DungeonCLEAR();
	}
}
