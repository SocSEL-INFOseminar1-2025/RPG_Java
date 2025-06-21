package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Fatalis extends BossMonster{
	public Fatalis() {
		super("MiComet", 100, 5);
	}
	
	public boolean special(AbstractParty enemies) {
		Random random = new Random();
		int specialType = random.nextInt(3);  // 0,1,2が入力されるように修正
		if(specialType == 0){
			System.out.println(super.getName() + "の溶岩バケツ!! 全ての勇者を焼き払う");
			AbstractCharacter [] heroes = enemies.getMembers();
			for(AbstractCharacter hero: heroes) {
				int randomAttack = random.nextInt(super.getAttack()) + 40;
				int damage = hero.gotDamage(randomAttack);
				System.out.println(hero.getName() + "に" + damage + "のダメージ");
				hero.actionStatus();
			}
		}else if(specialType == 1){
			System.out.println(super.getName() + "のソワレ!! 全ての勇者の攻撃力が5下がった!!");
			AbstractCharacter [] heroes = enemies.getMembers();
			for(AbstractCharacter hero: heroes) {
				int randomAttack = random.nextInt(super.getAttack()) + 40;
				int damage = hero.gotDamage(randomAttack);
				System.out.println(hero.getName() + "に" + damage + "のダメージ");
				hero.actionStatus();
			}
		}else if(specialType == 2){
			System.out.println(super.getName() + "のシュガーラッシュ!! 全てのHP上限を半減!!");
			AbstractCharacter [] heroes = enemies.getMembers();
			for(AbstractCharacter hero: heroes) {
				int randomAttack = random.nextInt(super.getAttack()) + 40;
				int damage = hero.gotDamage(randomAttack);
				System.out.println(hero.getName() + "に" + damage + "のダメージ");
				hero.actionStatus();
			}
		}
		return true;
	}
}
