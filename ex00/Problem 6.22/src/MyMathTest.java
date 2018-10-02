import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.stream.LongStream;

import org.junit.*;

public class MyMathTest {
	private LongStream sqrtTestNumbers;
	private LongStream getIntLetestNumbers;

	private double accuracy = 1E-6;

	@Before
	public void initialize() {
		sqrtTestNumbers = new Random().longs(0, 9223372036854775807L).limit(100);
		getIntLetestNumbers = new Random().longs(0, 9223372036854775807L).limit(50);
		MyMath.accuracy = accuracy;
	}

	@Test
	public void testSqrt() {
		double myAnswer;
		double officalAnswer;
		double difference;
		boolean assertion;

		LongStream defaultChecks = LongStream.of(-3, -2, -1, 0, 1, 2, 3, 4, 9, 16, 547, 9379, -9223372036854775808L,
				-9223372036854775807L, 9223372036854775806L, 9223372036854775807L);

		System.out.printf("[Sanity Check]\tsqrt(long n)\n");

		for (long n : LongStream.concat(defaultChecks, sqrtTestNumbers).toArray()) {
			myAnswer = MyMath.sqrt(n);
			officalAnswer = Math.sqrt(n);
			difference = Math.abs(officalAnswer - myAnswer);
			assertion = (Double.isNaN(officalAnswer) && Double.isNaN(myAnswer)) || difference < (accuracy * 1);
			assertTrue(assertion, String.format(
					"Your answer <%f> wasn't close enough to the native answer <%f>. Your answers differed by <%f>",
					myAnswer, officalAnswer, difference));
			System.out.printf("  + %-26s\t~= %-17f\t√\n", String.format("sqrt(%d)", n), myAnswer);
		}
	}

	@Test
	public void testGetIntLen() {
		assertEquals(MyMath.getLongLen(9), 1, "getIntLen(9) must return 1");
		assertEquals(MyMath.getLongLen(95), 2, "getIntLen9659) must return 2");
		assertEquals(MyMath.getLongLen(943), 3, "getIntLen(9) must return 3");
		assertEquals(MyMath.getLongLen(5436), 4, "getIntLen(9) must return 4");
		assertEquals(MyMath.getLongLen(9643563), 7, "getIntLen(9) must return 7");
	}

	@Test
	public void speedTestGetIntLen() {
		long start;
		double timePerCalculation;
		long[] testCases = getIntLetestNumbers.toArray();

		start = System.nanoTime();
		for (long n : testCases) {
			MyMath.getLongLen(n);
		}
		timePerCalculation = (System.nanoTime() - start) / 1e6 / testCases.length;
		System.out.printf("[Speed Test]\tgetIntLen(long n) -> Average: %fms (per call)\n", timePerCalculation);

		assertFalse(timePerCalculation > 0.09, "getLongLen(x) exceeded an average of 0.09 seconds per calculation");
	}
}
