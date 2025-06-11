package rpg.character.monster.monster;

import rpg.character.Specialist;
import rpg.character.monster.Monster;

public abstract class BossMonster extends Monster implements Specialist{
	public BossMonster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
}
