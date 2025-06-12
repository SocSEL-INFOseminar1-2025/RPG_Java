package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Priest extends AbstractSuperHero{
	public Priest(String name) {
		super(name, 100, 4);
		super.job = "僧侶";
	}
	
	public boolean special(AbstractParty targets) {
		AbstractCharacter [] members = targets.getMembers();
		for(AbstractCharacter member: members) {
			if(member.isDead() || member.isEscaped()) {
				return false;
			}
			Random random = new Random();
			int randomHeal = random.nextInt(3) * super.getAttack() + 15;
			int heal = member.gotHeal(randomHeal);
			System.out.println(super.getName() + "のスペシャルデリシャスヒール！！ " + member.getName() + "のHPを" + heal + "回復");  //いい回復魔法の名前を見つけたら変更
		}
		return true;
	}
}
