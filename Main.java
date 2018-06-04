public class Main {
	public static void main(String[] args) {
		Team teamA = initialize("Alpha");
		Team teamB = initialize("Beta");
	}

	public static Team initialize(String name) {
		return new Team(name);
	}
}
