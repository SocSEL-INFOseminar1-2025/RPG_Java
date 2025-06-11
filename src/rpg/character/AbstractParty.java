package rpg.character;

public abstract class AbstractParty {
	private AbstractCharacter[] members;
	
	public AbstractParty(AbstractCharacter[] members) {
		this.members = members;
	}
	
	protected boolean isEscapeAll() {
		boolean isEscapeAll = false;
		for(AbstractCharacter member: this.members) {
			if(!member.isEscaped()) {
				isEscapeAll = true;
			}
		}
		return isEscapeAll;
	}
	
	public boolean isAllDead() {
		boolean isAllDead = true;
		for(AbstractCharacter member: this.members) {
			if(!member.isDead()) {
				isAllDead = false;
			}
		}
		return isAllDead;
	}
	
	public String turn(AbstractParty enemies) {
		for(AbstractCharacter member: this.members) {
			if(!member.isDead() && !member.isEscaped()) {
				member.command(this, enemies);
				if(enemies.isAllDead()){
					return "BEAT";
				}
				if(this.isEscapeAll()){
					return "ESCAPE";
				}
			}
		}
		return "CONTINUE";
	}
	
	public AbstractCharacter[] getMembers() {
		return this.members;
	}
}
