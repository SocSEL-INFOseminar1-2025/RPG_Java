package rpg.character.monster.monster;

import rpg.character.AbstractParty;

public class ClearMonster extends BossMonster{
	public ClearMonster() {
		super("", 0, 0);
	}
	
	public boolean special(AbstractParty enemies) {
		return false;
	}

}
