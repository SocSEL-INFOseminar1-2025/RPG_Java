//package checkpoints;

import rpg.area.Dungeon1st;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;

public class Main{
	public static void main(String[] args) {
		// 勇者パーティ作成
		Hero[] heros = {
				new Warrior("戦士"),
				new Sorcerer("魔法使い"),
				new Priest("僧侶")
		};
		HeroParty party = new HeroParty(heros);
		
		// ダンジョン地下1階に行く
		// ドラゴンを倒したら終了
		Dungeon1st dungeon = new Dungeon1st();
		dungeon.access(party);
	}

}
