package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class HeroParty extends AbstractParty{
	public HeroParty(AbstractCharacter[] heroes) {
		super(heroes);
	}
	
	public void rest() {
		for(AbstractCharacter member: super.getMembers()) {
			Hero hero = (Hero) member;
			hero.rest();
		}
	}
	
	public void printPartyStatus() {
		for(AbstractCharacter member: super.getMembers()) {
			Hero hero = (Hero) member;
			if(hero.getHp() > 0  && !hero.isEscaped()) {
				System.out.print(hero.getName() + ")" + hero.getJob() + "(;" + hero.getHp() + " ");
			}else if(member.isEscaped()) {
				System.out.println(hero.getName() + "(" + hero.getJob() + "):死亡 ");
			}else if(member.getHp() <= 0) {
				System.out.println(hero.getName() + "(" + hero.getJob() + "):逃亡 ");
			}
		}
		System.out.println();
	}
	
	private void printPartyStatus(Hero hero) {
		for(AbstractCharacter member: super.getMembers()) {
			Hero hero = (Hero) member;
			if(hero.getHp() > 0  && !hero.isEscaped()) {
				System.out.print(hero.getName() + ")" + hero.getJob() + "(;" + hero.getHp() + " ");
			}else if(member.isEscaped()) {
				System.out.println(hero.getName() + "(" + hero.getJob() + "):死亡 ");
			}else if(member.getHp() <= 0) {
				System.out.println(hero.getName() + "(" + hero.getJob() + "):逃亡 ");
			}
		}
		System.out.println();
	}
	
	public boolean isEscapeAll() {
		return false;
	}
	
	public void init() {
		AbstractCharacter [] members = super.getMembers();
		for(AbstractCharacter member: members){
			member.init();
		}
	}
}
