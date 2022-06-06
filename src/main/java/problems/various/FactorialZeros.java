package problems.various;

/**
 * An algorithm which counts the number of trailing zeros in n factorial. The
 * factorial of a positive integer n, denoted by n!, is the product of all
 * positive integers less than or equal to n.
 * 
 * For example, 5! = 5 * 4 * 3 * 2 * 1 = 120
 * 
 * @author daryl
 *
 */
public class FactorialZeros {

	/**
	 * Counts the trailing zeros of n!. The number of trailing zeros is counted by
	 * recursively dividing n by exponents of 5 and adding the results together.
	 * This works because multiplication by 10 adds a zero to n. As 10 factors into
	 * the primes 2 and 5 we only need to count pairs of these. However, as 2 is
	 * always a lot more common as a factor, every even number has it, we only need
	 * to count 5 as a factor. This has a gotcha however, as 5 factors m times into
	 * 5^m, we need to count these as well and add everything together.
	 * 
	 * @param n the factorial of which to count trailing zeros.
	 * @return the number of trailing zeros in n!
	 */
	public static int countTrailingZerosOfFactorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Only non-negative numbers are allowed");
		}
		return recursiveCount(n, 5);
	}

	private static int recursiveCount(int n, int m) {
		if (n < m) {
			return 0;
		}
		return n / m + recursiveCount(n, m * 5);
	}
}
