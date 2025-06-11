package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.KingDemon;

public class Dungeon2nd extends Dungeon{
	public Dungeon2nd() {
		super.encountCounter = 0;
		super.floorNum = 2;
		super.setName("デーモンの間");
		
	}
	
	protected Monster nextBoss() {
		return new KingDemon();
	}
	
	protected Area nextArea() {
		return new Dungeon3rd();
	}
}
