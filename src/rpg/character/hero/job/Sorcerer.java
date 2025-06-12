package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Sorcerer extends AbstractSuperHero{
	public Sorcerer(String name) {
		super(name, 100, 15);
		super.job = "魔法使い";
	}
	
	public boolean special(AbstractParty targets) {
		if(targets.isAllDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(super.getAttack()) + super.getAttack();
		AbstractCharacter [] members = targets.getMembers();
		for(AbstractCharacter member: members) {
			int damage = member.gotDamage(randomAttack);
			System.out.println(super.getName() + "SUPERNOVA！！  " + member.getName() + "に" + damage + "のダメージ");
		}
		System.out.println(); //レイアウト調整のための改行
		return true;
	}
}
