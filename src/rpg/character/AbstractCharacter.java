package rpg.character;

import java.util.Random;

public abstract class AbstractCharacter {
	protected int attack;
	protected boolean escaped;
	private int hp, maxHp;
	private String name;
	
	protected AbstractCharacter(String name, int hp, int attack){
		this.attack = attack;
		this.hp = hp;
		this.maxHp = hp;
		this.name = name;
		this.escaped = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {  // HPの最大値をちょいちょいいじるので，publicへ変更
		this.hp = hp;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	private void setAttack(int i) {
		this.attack = i;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	private void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public boolean isDead() {
		if(this.hp > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean attack(AbstractParty enemies) {
		if(enemies.isAllDead()) {
			return false;
		}
		AbstractCharacter targetCharacter = null;
		targetCharacter = this.selectTarget(enemies);
		Random random = new Random();
		int randomAttack = random.nextInt(this.attack) + this.attack;
		int damage = targetCharacter.gotDamage(randomAttack);
		System.out.println(this.getName() + "の攻撃" + targetCharacter.getName() + "に" + damage + "のダメージ");
		targetCharacter.actionStatus();
		return true;
	}
	
	public int gotDamage(int damage) {
		if(this.hp - damage < 0) {
			damage = this.hp;
			this.hp = 0;
		}else {
			this.hp -= damage;
		}
		return damage;
	}
	
	public int gotHeal(int heal) {
		this.hp += heal;
		if(this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
		return heal;
	}
	
	public boolean isEscaped() {
		return false;
	}
	
	public void init() {
		this.escaped = false;
	}
	
	public void actionStatus() {
		if(this.isDead()) {
			System.out.println(this.name + "は倒れた");
		}
	}
	
	protected abstract void command(AbstractParty allies, AbstractParty enemies);
	
	protected abstract AbstractCharacter selectTarget(AbstractParty targets);
}
