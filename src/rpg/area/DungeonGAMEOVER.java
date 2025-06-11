package rpg.area;

import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.monster.ClearMonster;

public class DungeonGAMEOVER extends Dungeon{
	public Area access(HeroParty party) {
		System.out.println("ゲームオーバー！！");
		System.out.println("また挑戦してね");
		System.exit(0);
		return new TheEnd();
	}
	
	protected Monster nextBoss() {
		return new ClearMonster();
	}
	
	protected Area nextArea() {
		return new TheEnd();
	}
}
