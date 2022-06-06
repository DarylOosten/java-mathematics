package problems.various;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialZerosTest {

	@Test
	void testNegativeOneFactorial() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> FactorialZeros.countTrailingZerosOfFactorial(-1));
	}

	@Test
	void testZeroFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(0),
				FactorialZeros.countTrailingZerosOfFactorial(0));
	}

	@Test
	void testOneFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(1),
				FactorialZeros.countTrailingZerosOfFactorial(1));
	}

	@Test
	void testFourFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(4),
				FactorialZeros.countTrailingZerosOfFactorial(4));
	}

	@Test
	void testFiveFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(5),
				FactorialZeros.countTrailingZerosOfFactorial(5));
	}

	@Test
	void testSixFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(6),
				FactorialZeros.countTrailingZerosOfFactorial(6));
	}

	@Test
	void testNineFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(9),
				FactorialZeros.countTrailingZerosOfFactorial(9));
	}

	@Test
	void testTenFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(10),
				FactorialZeros.countTrailingZerosOfFactorial(10));
	}

	@Test
	void testElevenFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(11),
				FactorialZeros.countTrailingZerosOfFactorial(11));
	}

	@Test
	void testFourteenFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(14),
				FactorialZeros.countTrailingZerosOfFactorial(14));
	}

	@Test
	void testFifteenFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(14),
				FactorialZeros.countTrailingZerosOfFactorial(14));
	}

	@Test
	void testSixteenFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(16),
				FactorialZeros.countTrailingZerosOfFactorial(16));
	}

	@Test
	void testNineteenFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(19),
				FactorialZeros.countTrailingZerosOfFactorial(19));
	}

	@Test
	void testTwentyFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(20),
				FactorialZeros.countTrailingZerosOfFactorial(20));
	}

	@Test
	void testTwentyOneFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(21),
				FactorialZeros.countTrailingZerosOfFactorial(21));
	}

	@Test
	void testTwentyFiveFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(25),
				FactorialZeros.countTrailingZerosOfFactorial(25));
	}

	@Test
	void testFiftyFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(50),
				FactorialZeros.countTrailingZerosOfFactorial(50));
	}

	@Test
	void testHundredFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(100),
				FactorialZeros.countTrailingZerosOfFactorial(100));
	}

	@Test
	void testHundredAndTwentyfiveFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(125),
				FactorialZeros.countTrailingZerosOfFactorial(125));
	}

	@Test
	void testHundredAndFiftyFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(150),
				FactorialZeros.countTrailingZerosOfFactorial(150));
	}

	@Test
	void testSixHundredAndTwentyfiveFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(625),
				FactorialZeros.countTrailingZerosOfFactorial(625));
	}

	@Test
	void testTenThousandFactorial() {
		Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(10000),
				FactorialZeros.countTrailingZerosOfFactorial(10000));
	}

	@Test
	void testZeroToThousandFactorial() {
		for (int i = 0; i < 1000; i++) {
			Assertions.assertEquals(countTrailingZerosOfAxiomaticFactorial(i),
					FactorialZeros.countTrailingZerosOfFactorial(i));
		}
	}

	/**
	 * Calculates the factorial of n and counts the number of trailing zeros.
	 * 
	 * @param n for which to calculate the factorial.
	 * @return the number of trailing zeros in the factorial of n.
	 */
	public static int countTrailingZerosOfAxiomaticFactorial(int n) {
		BigInteger nFactorial = axiomaticFactorial(BigInteger.valueOf(n));
		return nFactorial.toString().length() - nFactorial.toString().replaceAll("0+$", "").length();
	}

	/**
	 * Calculates the factorial of n in an axiomatic way: n! = n * (n - 1)!
	 * 
	 * @param n for which to calculate factorial.
	 * @return the factorial of n.
	 */
	public static BigInteger axiomaticFactorial(BigInteger n) {
		if (n.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalArgumentException("Only non-negative numbers are allowed");
		}
		if (n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		return n.multiply(axiomaticFactorial(n.subtract(BigInteger.ONE)));
	}

}
