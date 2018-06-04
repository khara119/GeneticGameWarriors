import java.util.Random;

public class Warrior extends SemiWarrior {
	protected int itemAttack;
	protected int itemDefense;

	public Warrior() {
	}

	public Warrior(String team) {
		super(team);
		Random random = new Random();
		itemAttack = random.nextInt(90) + 10;
		itemDefense = random.nextInt(90) + 10;
	}

	public Warrior(SemiWarrior child) {
		team = child.team;
		id = child.id;
		maxLife = child.maxLife;
		life = child.life;
		maxHP = child.maxHP;
		hp = child.hp;
		attack = child.attack;
		defense = child.defense;
		speed = child.speed;

		Random random = new Random();
		itemAttack = random.nextInt(90) + 10;
		itemDefense = random.nextInt(90) + 10;
	}

	@Override
	public String toString() {
		return super.toString() +
			"itemATK:\t" + itemAttack + "\n" +
			"itemDEF:\t" + itemDefense + "\n";
	}
}
