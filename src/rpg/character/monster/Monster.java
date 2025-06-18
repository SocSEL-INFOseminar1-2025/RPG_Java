package rpg.character.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public abstract class Monster extends AbstractCharacter{
	public Monster(String name, int hp, int attack) {
		super(name, attack, hp);
	}
	
	protected void command(AbstractParty ally, AbstractParty enemies) {
		System.out.println(super.getName() + "の行動");
		while(true) {
			if(super.attack(enemies)) {
				break;
			}else {
				this.command(ally, enemies);
			}
		}
	}
	
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		AbstractCharacter [] enemies = targets.getMembers();
		int numPartyMember = enemies.length;
		Random random = new Random();
		int target;
		do {
			target = random.nextInt(numPartyMember);
		}while(enemies[target].isDead());
		return enemies[target];
	}
}
