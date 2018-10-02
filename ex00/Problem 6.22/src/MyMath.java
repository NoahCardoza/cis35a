public class MyMath {
	// default accuracy
	public static double accuracy = 1E-6;

	// Revised version of:
	// https://github.com/NoahCardoza/42-C-Piscine/blob/c2ffe36899793756f8eec642efb6c088310e14f8/piscine/day04/ex05/ft_sqrt.c
	public static int getLongLen(long n) {
		return ((int) (Math.log10(n))) + 1;
	}

	public static double sqrt(long n) {
		double lastGuess;
		double nextGuess;

		if (n < 0)
			return Double.NaN;
		if (n == 0)
			return 0.0;

		lastGuess = 1;
		nextGuess = (n / getLongLen(n) / 2) + 1;

		while (Math.abs(lastGuess - nextGuess) > accuracy) {
			lastGuess = nextGuess;
			nextGuess = (lastGuess + n / lastGuess) / 2;
		}

		return nextGuess;
	}
}