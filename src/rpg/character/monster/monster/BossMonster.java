package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.Specialist;
import rpg.character.monster.Monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public abstract class BossMonster extends Monster implements Specialist{
	public BossMonster(String name, int hp, int attack) {
		super(name, hp, attack);
	}

	protected void command(AbstractParty ally, AbstractParty enemies) {
		System.out.println(super.getName() + "の行動");
		Random random = new Random();
		int command = random.nextInt(2);  
		if(command == 0) {
			while(true) {
				if(super.attack(enemies)) {
					break;
				}else {
					this.command(ally, enemies);
				}
			}
		}else if(command == 1){
			while(true) {
				if(this.special(enemies)) {
					break;
				}else {
					this.command(ally, enemies);
				}
			}
		}else{
			this.command(ally, enemies);
		}
	}
}
