package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.MonsterParty;

public class BattleField extends Object{
	public static String battle(HeroParty heroes, MonsterParty monsters) {
		heroes.init();
		AbstractCharacter [] enemies = monsters.getMembers();
		for(AbstractCharacter enemy: enemies) {
			System.out.print(enemy.getName() + " ");
		}
		System.out.println("があらわれた");
		while(true) {
			System.out.println("勇者のターン");
			heroes.printPartyStatus();
			String flg = heroes.turn(monsters);
			if(flg.equals("BEAT")) {
				return "WIN";
			}else if(flg.equals("ESCAPE")) {
				return "ESCAPE";
			}
			
			System.out.println("モンスターのターン");
			flg = monsters.turn(heroes);
			if(flg.equals("BEAT")) {
				return "LOSE";
			}
		}
	}
}
