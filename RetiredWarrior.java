import java.util.Random;

public class RetiredWarrior extends Warrior {
	private double teachRate;

	public RetiredWarrior() {
	}

	public RetiredWarrior(String team) {
		super(team);
		Random random = new Random();
		teachRate = (int)(random.nextDouble() * 100) / 100.0;
	}

	public RetiredWarrior(Warrior child) {
		team = child.team;
		id = child.id;
		maxLife = child.maxLife;
		life = child.life;
		maxHP = child.maxHP;
		hp = child.hp;
		attack = child.attack;
		defense = child.defense;
		speed = child.speed;
		itemAttack = child.itemAttack;
		itemDefense = child.itemDefense;

		Random random = new Random();
		teachRate = (int)(random.nextDouble() * 100) / 100.0;
	}

	public String toString() {
		return super.toString() +
			"TCHRate:\t" + teachRate + "\n";
	}
}
