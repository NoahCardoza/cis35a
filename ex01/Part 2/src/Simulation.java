import java.util.stream.IntStream;

public class Simulation {
	private int iterations = 20;

	public void toss(Coin coin) {
		int heads = IntStream.range(1, iterations + 1).map(i -> {
			coin.toss();
			System.out.printf("%02d – %s\n", i, coin.getSideUp());
			return coin.getSideUp() == "heads" ? 1 : 0;
		}).sum();

		System.out.printf("\nAfter flipping the coin the %d times, it landed heads %d times and tails %d times.\n",
				iterations, heads, iterations - heads);
	}
}
