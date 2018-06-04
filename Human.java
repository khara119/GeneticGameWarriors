import java.util.Random;

public class Human extends Thread {
	protected String team;
	protected String id;
	protected long maxLife;
	protected long life;
	protected int maxHP;
	protected int hp;
	protected int attack;
	protected int defense;
	protected int speed;
	

	public Human() {
		this("NO TEAM");
	}

	public Human(String team) {
		Random random = new Random();
		this.team = team;
		id = generateID();
		maxLife = life = (random.nextInt(40) + 60) * 60 * 24 * 365;
		maxHP = hp = random.nextInt(11) + 5;
		attack = random.nextInt(11) + 5;
		defense = random.nextInt(11) + 5;
		speed = random.nextInt(11) + 100;
	}

	public Human(Warrior parent) {
		Random random = new Random();
		team = parent.team;
		id = generateID();
		maxLife = life = random.nextInt(40) + 60;
		maxHP = hp = parent.getMaxHP() / 10;
		attack = parent.getAttack() / 10;
		defense = parent.getDefense() / 10;
		speed = parent.getSpeed() + 90;
	}

	@Override
	public void run() {
		System.out.println("==========");
		System.out.println(this);
		System.out.println("==========");
	}

	public String generateID() {
		String vowel = "AIUEO";
		String consonant = "KSTNHMYRWGZDB";

		Random random = new Random();
		int combination = random.nextInt(4) + 2;

		String id = "";
		for (int i=0; i<combination; i++) {
			int cIdx = random.nextInt(consonant.length() + 1) - 1;
			int vIdx = random.nextInt(vowel.length());

			if (cIdx >= 0) {
				id += consonant.substring(cIdx, cIdx+1);
			}

			id += vowel.substring(vIdx, vIdx+1);
		}

		String[][] replaceTemplates = {
			{"ZI", "JI"},
			{"SI", "SHI"},
			{"TI", "CHI"},
			{"TU", "TSU"},
			{"HU", "FU"},
			{"YI", "I"},
			{"YE", "E"},
			{"WI", "I"},
			{"WU", "U"},
			{"WE", "E"},
			{"WO", "O"}
		};

		for (int i=0; i<replaceTemplates.length; i++) {
			String regex = replaceTemplates[i][0];
			String replacement = replaceTemplates[i][1];

			id = id.replaceAll(regex, replacement);
		}

		return id;
	}

	public long getMaxLife() {
		return maxLife;
	}

	public long getLife() {
		return life;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void updateMaxHP(int delta) {
		maxHP += delta;
		hp += delta / maxHP;
	}

	public int getHP() {
		return hp;
	}

	public void updateHP(int delta) {
		hp += delta;
	}

	public int getAttack() {
		return attack;
	}

	public void updateAttack(int delta) {
		attack += delta;
	}

	public int getDefense() {
		return defense;
	}

	public void updateDefense(int delta) {
		defense += delta;
	}

	public int getSpeed() {
		return speed;
	}

	public void updateSpeed(int delta) {
		speed += delta;
	}

	@Override
	public String toString() {
		String str = "  Class:\t" + getClass().getSimpleName() + "\n";
		str += "   Team:\t" + team + "\n";
		str += "     ID:\t" + id + "\n";
		str += "MaxLife:\t" + maxLife + "(" + (maxLife/(60*24*365)) + ")\n";
		str += "   Life:\t" + life + "(" + (maxLife/(60*24*365)) + ")\n";
		str += "  MaxHP:\t" + maxHP + "\n";
		str += "     HP:\t" + hp + "\n";
		str += " Attack:\t" + attack + "\n";
		str += "Defense:\t" + defense + "\n";
		str += "  Speed:\t" + speed + "\n";

		return str;
	}
}
