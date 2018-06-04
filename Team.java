import java.util.ArrayList;

public class Team {
	private static final int TOTAL_WARRIORS = 100;
	private String name;
	private ArrayList<Human> warriors;

	public Team(String name) {
		this.name = name;
		warriors = new ArrayList<>();

		for (int i=0; i<TOTAL_WARRIORS/4; i++) {
			SemiWarrior sw = new SemiWarrior(name);
			Warrior w = new Warrior(name);
			RetiredWarrior rw = new RetiredWarrior(name);

			sw.start();
			w.start();
			rw.start();

			warriors.add(sw);
			warriors.add(w);
			warriors.add(rw);
		}

		for (int i=0; i<TOTAL_WARRIORS/4; i++) {
			Warrior w = new Warrior(name);
			w.start();
			warriors.add(w);
		}
	}

	public ArrayList<Human> getWarriors() {
		return warriors;
	}
}
