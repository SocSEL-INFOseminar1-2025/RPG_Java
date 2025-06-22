package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

public class Hotel extends Area{
	public Hotel() {
		super.setName("宿屋");
	}
	
	public void printArea() {
		System.out.println("現在の場所は" + super.getName() + "です．");
	}
	
	public void rest(HeroParty party) {
		party.rest();
	}
	
	public Area access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while(true) {
			System.out.println("どうしますか");
			System.out.println("1:休息する　2:はじまりの町へ戻る");
			int nextMove = ScanCommand.scan();
			if (nextMove == 1) {
				System.out.println("勇者たちは"+getName()+"に泊まった!元気いっぱい!");
				System.out.println("");
				this.rest(party);
			}
			Town town = new Town();
			town.access(party);
		}
	}
}
