import java.util.Random;

// import java.util.Random;

public class Coin {
	private String sideUp;
	private Random rand = new Random();

	public Coin() {
		toss();
	}

	public void toss() {
		sideUp = rand.nextBoolean() ? "heads" : "tails";
	}

	public String getSideUp() {
		return sideUp;
	}
}
