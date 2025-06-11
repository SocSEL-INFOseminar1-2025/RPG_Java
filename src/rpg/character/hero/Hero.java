package rpg.character.hero;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.Specialist;

public class Hero extends AbstractCharacter {
	protected String job;
	
	public Hero(String name, int hp, int attack){
		super(name, hp, attack);
		this.job = "普通のヒーロー";
	}
	
	public void run() {
		System.out.println(super.getName() + "は逃げ出した");
		super.escaped = true;
	}
	
	public void rest() {
		super.gotHeal(super.getMaxHp());
	}
	
	//これらのメソッドはAbstractCharacterで抽象メソッドとして定義し、Heroで実装するとかなんとか
	protected void command(AbstractParty allies, AbstractParty enemies) {
		System.out.println(super.getName() + "(" + this.getJob() + ")の行動:");
		System.out.println("1: 戦う  2: 逃げる  3: 必殺技");
		int command = ScanCommand.scan();
		if(command == 1) {  //戦う
			while(true) {
				if(super.attack(enemies)) {
					break;
				}
			}
		}else if(command == 2) {  //逃亡
			this.run();
		}else if(command == 3) {  //必殺技
			if(this instanceof Specialist) {
				Specialist specialist = (Specialist) this;
				while(true) {
					if(this.getJob().equals("僧侶")) {
						if(specialist.special(allies));
						break;
					}else {
						if(specialist.special(enemies));
						break;
					}
				}
			}
		}else {
			this.command(allies, enemies);
		}
	}
	
	public String getJob() {
		return this.job;
	}
	
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		System.out.println("対象は");
		AbstractCharacter [] enemies = targets.getMembers();
		int numPartyMember = enemies.length;
		for(int i = 0; i < numPartyMember; i++) {
			AbstractCharacter enemy = enemies[i];
			if(!enemy.isDead() && !enemy.isEscaped()) {
				System.out.println(i + ":" + enemy.getName());
			}
		}
		int target = ScanCommand.scan();
		System.out.println();
		if (target < numPartyMember) {
			if (!enemies[target].isDead()) {
				return enemies[target];
			} else {
				return selectTarget(targets);
			}
		} else {
			return selectTarget(targets);
		}
	}
}
