package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Fatalis extends BossMonster{
	public Fatalis() {
		super("ミラボレアス", 100, 5);
	}
	
	public boolean special(AbstractParty enemies) {
		Random random = new Random();
		System.out.println(super.getName() + "の劫火，全ての勇者を焼き払う");
		AbstractCharacter [] heroes = enemies.getMembers();
		for(AbstractCharacter hero: heroes) {
			int randomAttack = random.nextInt(super.getAttack()) + 40;
			int damage = hero.gotDamage(randomAttack);
			System.out.println(hero.getName() + "に" + damage + "のダメージ");
			hero.actionStatus();
		}
		return true;
	}
}
