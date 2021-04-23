package hackerrank.sorting;

public class Player {

	String name;
	long score;
	
	public Player(String name, long score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Name = " + name + "; score = " + score;
	}
	
	
	
}
