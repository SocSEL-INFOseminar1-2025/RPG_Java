package rpg.area;

import rpg.character.hero.HeroParty;

public class TheEnd extends Area{
	public TheEnd() {
		super.setName("おわりの地");
	}
	
	public void printArea() {
	}
	
	public void rest(HeroParty party) {
		party.rest();
	}
	
	public Area access(HeroParty party) {
		while(true) {
			Town town = new Town();
			town.access(party);
		}
	}
}
