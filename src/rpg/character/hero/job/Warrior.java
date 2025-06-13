package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Warrior extends AbstractSuperHero{
	public Warrior(String name) {
		super(name, 100, 30);
		super.job = "戦士";
	}
	
	public boolean special(AbstractParty targets) {
		AbstractCharacter targetCharacter = this.selectTarget(targets);
		if (targetCharacter.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(super.getAttack()) + super.getAttack();
		if(targetCharacter.getName().equals("Dragon")) {  //ドラゴンに対して，攻撃に補正がかかる
			randomAttack += 30;
		}
		int damage = targetCharacter.gotDamage(randomAttack);
		System.out.println(super.getName() + "のHAPPY BANG!!  " + targetCharacter.getName() + "に" + damage + "のダメージ");
		System.out.println(); //レイアウト調整のための改行
		return true;
	}
}
