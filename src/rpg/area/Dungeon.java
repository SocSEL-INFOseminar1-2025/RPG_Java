package rpg.area;

import java.util.Random;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.BabyDragon;
import rpg.character.monster.monster.Demon;
import rpg.character.monster.monster.Minotaur;

public abstract class Dungeon extends Area{
	protected int floorNum = 1, encountCounter;
	
	protected abstract Monster nextBoss();
	
	protected abstract Area nextArea();
	
	public Area access(HeroParty party) {
		this.printArea();
		while (true) {
			System.out.println("どうしますか");
			System.out.println("1:探索する　2：はじまりの町へ戻る");
			int nextMove = ScanCommand.scan();
			if(nextMove == 1) {  //探索
				String result = this.explore(party);
				if(result.equals("WIN")) {
					Area dungeon = this.nextArea();
					dungeon.access(party);
				}else if(result.equals("LOSE")) {
					DungeonGAMEOVER GAMEOVER = new DungeonGAMEOVER();
					GAMEOVER.access(party);
				}
			}else if(nextMove == 2) {  //街に戻る
				Town town = new Town();
				town.access(party);
			}else {
				this.access(party);
			}
		}
	}
	
	public String explore(HeroParty party) {
		String result;
		while (true) {
			//this.printExplore();  トコトコって出力する演出部分
			//Random random = new Random();
			//int randomNum = random.nextInt(5);  //これ何？ 2割の確率でボスと戦えるみたいな仕様だった?
			if(this.encountCounter >= 3) {
				result = this.encountBoss(party);
				if(result.equals("ESCAPE")){
					continue;
				}
				return result;
			} else {
				result = this.encountMob(party);
				if(result.equals("LOSE")){
					return result;
				}
				this.encountCounter++;
			} 
		}
	}
	
	public void printArea() {
		System.out.println("現在の場所は" + super.getName() + "地下" + this.floorNum + "階です．" );
	}
	
	private String encountMob(HeroParty party) {
		System.out.println("モンスターと遭遇した");
		Random random = new Random();
		int numOfMonster = random.nextInt(3) + 1;
		Monster [] Mob = new Monster[numOfMonster];
		MonsterParty mpty = new MonsterParty(Mob);
		for(int i = 0; i < numOfMonster; i++) {
			if(this.floorNum == 1) {
				Mob[i] = new BabyDragon(i);
			}else if(this.floorNum == 2) {
				Mob[i] = new Demon(i);
			}else if(this.floorNum == 3) {
				Mob[i] = new Minotaur(i);
			}
			
		}
		String result = BattleField.battle(party, mpty);
		for(int i = 0; i < numOfMonster; i++) {
			this.printBattleResult(result, Mob[i].getName());
		}
		return result;
	}
	
	private String encountBoss(HeroParty party) {
		System.out.println("ボスモンスターと遭遇した");
		Monster [] Boss = new Monster[1];
		Boss[0] = this.nextBoss();
		MonsterParty mpty = new MonsterParty(Boss);
		String result = BattleField.battle(party, mpty);
		this.printBattleResult(result, Boss[0].getName());
		return result;
	}
	
	private void printBattleResult(String result, String string) {
		if (result.equals("WIN")) {
			System.out.println("勇者たちは"+string+"に勝利した");
		} else if(result.equals("LOSE")){
			System.out.println("勇者たちは"+string+"に敗北した");
		} else if(result.equals("ESCAPE")){
			System.out.println("勇者たちは"+string+"から逃げ出した");
		}	
	}
}
