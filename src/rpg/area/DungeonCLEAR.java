package rpg.area;

import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.monster.ClearMonster;

public class DungeonCLEAR extends Dungeon{
	public Area access(HeroParty party) {
		System.out.println("ゲームクリア！！");
		try {
			Thread.sleep(1000);
			System.out.println("Cast");
			AbstractCharacter [] heroes = party.getMembers();
			for(int i = 1; i <= heroes.length; i++) {
				Hero hero = (Hero) heroes[i - 1];
				System.out.println("ヒーロー" + i + "：" + hero.getName() + "(" + hero.getJob() + ")");
			}
			
			System.out.println("お");
			Thread.sleep(1000);
			System.out.println("わ");
			Thread.sleep(1000);
			System.out.println("り");
			System.exit(0);
			
			//とりあえずはじまりの町に帰る（エモエモ展開ktkr）
			return new Town();
			
		}catch(InterruptedException e) {
			throw new Error();
		}
	}
	
	protected Monster nextBoss() {
		return new ClearMonster();
	}
	
	protected Area nextArea() {
		return new TheEnd();
	}
}
