package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class KingDemon extends BossMonster{
	public KingDemon() {
		super("キングデーモン", 100, 5);
	}
	
	public boolean special(AbstractParty enemies) {
		Random random = new Random();
		System.out.println(super.getName() + "のギガドレイン，勇者全員から体力を吸い取った");
		AbstractCharacter [] heroes = enemies.getMembers();
		for(AbstractCharacter hero: heroes) {
			int randomAttack = random.nextInt(super.getAttack()) + super.getAttack();
			int damage = hero.gotDamage(randomAttack);
			System.out.println(hero.getName() + "に" + damage + "のダメージ");
			super.setHp(super.gotHeal(damage));
			hero.actionStatus();
		}
		return true;
	}
}
