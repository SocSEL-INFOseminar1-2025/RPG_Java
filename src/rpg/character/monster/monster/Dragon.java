package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Dragon extends BossMonster{
	public Dragon() {
		super("ドラゴン", 200, 30);
	}
	
	public boolean special(AbstractParty enemies) {
		Random random = new Random();
		System.out.println(super.getName() + "の竜のいぶき，勇者全員に激しい嵐が襲いかかる");
		AbstractCharacter [] heroes = enemies.getMembers();
		for(AbstractCharacter hero: heroes) {
			int randomAttack = random.nextInt(super.getAttack()) + super.getAttack();
			int damage = hero.gotDamage(randomAttack);
			System.out.println(hero.getName() + "に" + damage + "のダメージ");
			hero.actionStatus();
		}
		return true;
	}
}
