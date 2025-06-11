package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.Dragon;

public class Dungeon1st extends Dungeon{
	public Dungeon1st() {
		super.setName("ドラゴンの巣窟");
	}
	
	protected Monster nextBoss() {
		return new Dragon();  //BigMatangoって仕様書には書いてるけど，多分Dragonよな？
	}
	
	protected Area nextArea() {
		return new Dungeon2nd();
	}
}
